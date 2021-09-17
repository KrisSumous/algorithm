package com.kris.sword2offer;

import java.util.Arrays;

/*
#### 一、题目

输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc。则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba。

#### 二、解题思路

把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。

我们求整个字符串的排列，可以看成两步：首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。

这其实是很典型的递归思路。
 */
public class problem_25 {

    public static void main(String[] args) {
        permutation(new char[]{'a', 'b', 'c'});
    }
    public static void permutation(char[] chars) {
        if (chars == null || chars.length < 1) {
            return;
        }
        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int start) {
        if (chars.length - 1 == start) {
            System.out.println(chars);
        } else {
            char tmp;
            for (int i = start; i < chars.length; i++) {
                tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;

                permutation(chars, start + 1);
            }
        }
    }


}
