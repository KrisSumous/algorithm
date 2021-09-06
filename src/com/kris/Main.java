package com.kris;

import com.kris.queue.ArrayQueue;
import com.kris.tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(11);
        binarySearchTree.add(3);
        binarySearchTree.add(12);
        binarySearchTree.add(17);
        binarySearchTree.add(4);
        binarySearchTree.add(18);
        binarySearchTree.add(1);
        binarySearchTree.add(6);


        binarySearchTree.inOrder();


    }


    public static void headSort(int[] numbers) {
        int arrayLength = numbers.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(numbers, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(numbers, 0, arrayLength - 1 - i);
        }
    }

    // 对numbers数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] numbers, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的字节点存在`
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex + 1代表k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 如果右子节点的值较大
                    if (numbers[biggerIndex] < numbers[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                if (numbers[k] < numbers[biggerIndex]) {
                    swap(numbers, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }


    public static int[] quickSort(int[] numbers) {
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
        return numbers;
    }

    private static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = getMiddle(numbers, low, high);
        quickSort(numbers, low, middle - 1);
        quickSort(numbers, middle + 2, high);
    }

    private static int getMiddle(int[] numbers, int low, int high) {
        int tmp = numbers[low];
        while (low < high) {
            while (low < high && numbers[high] > tmp) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] < tmp) {
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = tmp;
        return low;
    }

    // tmp = 4

    // 1,3,4,2,5,6


}
