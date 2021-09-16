package com.kris;

public class test {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 5);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return binarySearch(arr, num, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int num, int start, int end) {
        if (start + 1 == end) {
            if (arr[start] == num) {
                return start;
            } else if (arr[end] == num) {
                return end;
            } else {
                return -1;
            }
        }
        int middle = (start + end) / 2;
        if (num < arr[middle]) {
            return binarySearch(arr, num, start, middle);
        } else if (num > arr[middle]) {
            return binarySearch(arr, num, middle, end);
        } else {
            return middle;
        }
    }
}
