package com.kris.sword2offer;

/*
一、题目
请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制1001，有2位1。因此如果输入9，该函数输出2。

二、解题思路
① 位移+计数，每次右移一位，不断和1进行计算，直到位0
② 循环让（n - 1）& n。如果n的二进制表示中有k个1，那么这个方法只需要循环k次即可。其原理是不断地清除n的二进制表示中最右边的1，同时累加计数器，
直至n为0，因为从二进制的角度讲，n相当于在n-1的最低位上加1。举个例子，8（1000）= 7（0111），所以 8 & 7 = 0，
清除了8最右边的1（其实就是最高位的1，因为8的二进制中只有一个1）。再比如7（0111）= 6（0110）+ 1（0001），
所以7 & 6 = 6（0110），清除了7的二进制表示中最右边的1（也就是最低位的1）
 */
public class problem_08 {

    public static void main(String[] args) {
        System.out.println(numberOfOne2(7));
    }

    public static int numberOfOne(int n) {
        int result = 0;
        // java语言规范中，int整型占4个字节，总计32位
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            // >>> : 右移赋值，左边空出的位以0填充
            n >>>= 1;
        }
        return result;
    }

    public static int numberOfOne2(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = (n - 1) & n;
        }
        return result;
    }

}
