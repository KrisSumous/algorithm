package com.kris.sword2offer;

import java.util.ArrayList;
import java.util.List;

/*
#### 一、题目

输入n个整数，找出其中最小的k个数。
例子说明：
例如输入4 、5 、1、6、2、7、3 、8 这8 个数字，则最小的4个数字是1 、2、3、4

#### 二、解题思路

解法一：O(n)时间算法，只有可以修改输入数组时可用。

可以基于Partition函数来解决这个问题。如果基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，
比第k个数字大的所有数字都位于数组的右边。这样调整之后，位于数组中左边的k个数字就是最小的k 个数字（这k 个数字不一定是排序的〉。

解法二： O（nlogk）的算法，精剧适合处理海量数据。

先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数．如果容器中已有的数字少于k个，
则直接把这次读入的整数放入容器之中：如果容器中己有k 数字了，也就是容器己满，此时我们不能再插入新的数字而只能替换已有的数字。
找出这己有的k 个数中的最大值，然后1在这次待插入的整数和最大值进行比较。如果待插入的值比当前己有的最大值小，则用这个数替换当前已有的最大值：
如果待插入的值比当前已有的最大值还要大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。
因此当容器满了之后，我们要做3 件事情： 一是在k个整数中找到最大数： 二是有可能在这个容器中删除最大数： 三是有可能要插入一个新的数字。
我们可以使用一个大顶堆在O(logk）时间内实现这三步操作。
 */
public class problem_27 {


    private final static class MaxHeap<T extends Comparable<T>> {
        private List<T> items;
        private int cursor;

        public MaxHeap(int size) {
            items = new ArrayList<>();
            cursor = -1;
        }

        public MaxHeap() {
            this(32);
        }

        // 上浮
        public void siftUp(int index) {
            T intent = items.get(index);
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                T parent = items.get(parentIndex);
                if (intent.compareTo(parent) > 0) {
                    items.set(index, parent);
                    index = parentIndex;
                } else {
                    break;
                }
            }
            items.set(index, intent);
        }

        // 下潜
        public void siftDown(int index) {
            T intent = items.get(index);
            int leftIndex = 2 * index + 1;
            while (leftIndex < items.size()) {
                T maxChild = items.get(leftIndex);
                int maxIndex = leftIndex;
                int rightIndex = leftIndex + 1;
                if (rightIndex < items.size()) {
                    T rightChild = items.get(rightIndex);
                    if (rightChild.compareTo(maxChild) > 0) {
                        maxChild = rightChild;
                        maxIndex = rightIndex;
                    }
                }
                if (maxChild.compareTo(intent) > 0) {
                    items.set(index, maxChild);
                    index = maxIndex;
                    leftIndex = index * 2 + 1;
                } else {
                    break;
                }
            }
            items.set(index, intent);
        }

        public void add(T item) {
            items.add(item);
            siftUp(items.size() - 1);
        }

        public T deleteTop() {
            if (items.isEmpty()) {
                throw new RuntimeException("Heap is Empty");
            }
            T maxItem = items.get(0);
            T lastItem = items.remove(items.size() - 1);
            if (items.isEmpty()) {
                return lastItem;
            }
            items.set(0, lastItem);
            siftDown(0);
            return maxItem;
        }

        public T Next() {
            if (cursor >= items.size()) {
                throw new RuntimeException("No More element");
            }
            return items.get(cursor);
        }

        public boolean hasNext() {
            cursor++;
            return cursor < items.size();
        }

        public T first() {
            if (items.size() == 0) {
                throw new RuntimeException("heap is Empty");
            }
            return items.get(0);
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

        public int size() {
            return items.size();
        }

        public void clear() {
            items.clear();
        }

        @Override
        public String toString() {
            return items.toString();
        }
    }


    public static void getLeastNumbers32(int[] input, int[] output) {
        if (input == null || output == null || output.length <= 0 || input.length <= output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>(output.length);
        for (int i: input) {
            if (maxHeap.size() < output.length) {
                maxHeap.add(i);
            } else {
                int max = maxHeap.first();
                if (max > i) {
                    maxHeap.deleteTop();
                    maxHeap.add(i);
                }
            }
        }

        for (int i = 0; maxHeap.hasNext(); i++) {
            output[i] = maxHeap.Next();
        }
    }



}



