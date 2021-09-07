package com.kris.sort;

public class sort {

    public static void main(String[] args) {
        int[] numbers = shellSort(new int[]{3, 5, 7, 6, 4, 2, 1});
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    // 冒泡排序
    public static int[] bubbleSort(int[] numbers) {
        int tmp;
        int size = numbers.length;
        boolean flag = true;
        for (int i = 0; i < size - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                    flag = true;
                }
            }
        }
        return numbers;
    }

    // 选择排序
    public static int[] selectSort(int[] numbers) {
        int size = numbers.length;
        int tmp;
        for (int i = 0; i < size - 1; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            tmp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = tmp;
        }
        return numbers;
    }

    // 插入排序
    public static int[] insertSort(int[] numbers) {
        int size = numbers.length;
        int tmp;
        int j;
        for (int i = 1; i < size; i++) {
            tmp = numbers[i];
            for (j = i; j > 0 && tmp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = tmp;
        }
        return numbers;
    }

    /*
     * 希尔排序的原理:根据需求，如果你想要结果从小到大排列，它会首先将数组进行分组，然后将较小值移到前面，较大值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，
     * 可以说希尔排序是加强版的插入排序， 拿数组5,2,8,9,1,3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从小到大排列，所以小的会排在前面，第一次排序后数组为5,1,3,4,2,8,9
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，实现数组从小到大排序
     */
    public static int[] shellSort(int[] numbers) {
        int j;
        int tmp;
        // 每次将步长缩短为原先的一半
        for (int increment = numbers.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < numbers.length; i++) {
                tmp = numbers[i];
                for (j = i; j >= increment; j -= increment) {
                    if (tmp < numbers[j - increment]) {
                        numbers[j] = numbers[j - increment];
                    } else {
                        break;
                    }
                }
                numbers[j] = tmp;
            }
        }
        return numbers;
    }

    // 堆排序
    public static void heapSort(int[] numbers) {
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


    // 快速排序
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

}
