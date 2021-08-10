package com.kris.sword2offer;

/*
一、题目
输入数字n，按顺序打印从1到n位最大十进制的数值。比如输入3，则打印1、2、3一直到最大数即999。

二、解题思路
① 使用一个n位的数组来存储每一位的元素。例如n位3，则000表示位[0, 0, 0]。使用递归的方式，存放每一位元素值

② 同上，使用一个n位的数组来存储每一位元素。然后循环执行加1操作，并在数组中进行模拟进位，直到最高位需要进位，则表示循环结束。
 */
public class problem_09 {

    public static void main(String[] args) {
        printOneToNthDigits(2);
    }

    public static void printOneToNthDigits(int n) {
        if (n < 1) {
            throw new RuntimeException("The Input Number must larger than 0");
        }
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    private static void printOneToNthDigits(int n, int[] arr) {
        if (n >= arr.length) {
            printArray(arr);
        } else {
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    private static void printArray(int[] arr) {
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        if (index < arr.length) {
            System.out.println();
        }
    }



    public static void printOneToNthDigits2(int n) {
        if (n < 1) {
            throw new RuntimeException("The Input Number must larger than 0");
        }
        int[] arr = new int[n];
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    private static int addOne(int[] arr) {
        // 保存进位值，因为每次最低值加1
        int carry = 1;
        // 最低位的位置的后一位
        int index = arr.length;
        do {
            index--;
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] %= 10;
        } while (carry != 0 && index > 0);
        // 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回1
        if (carry > 0) {
            return 1;
        }
        // 无进位返回0
        return 0;
    }

}
