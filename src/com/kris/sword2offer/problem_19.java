package com.kris.sword2offer;

import java.util.Stack;

/*
一、题目
输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。

二、解题思路
解决这个问题很直观的想法就是建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从该栈中弹出数字。
判断一个序列是不是栈的弹出序列的规律：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，
我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 */
public class problem_19 {
    public static void main(String[] args) {
        boolean isPop = sequenceIsPop2(new int[]{1, 2, 3}, new int[]{3, 1, 1});
        System.out.println(isPop);
    }

    private static boolean sequenceIsPop1(int[] data1, int[] data2) {
        Stack<Integer> stack = new Stack<>();
        for (int i : data1) {
            stack.push(i);
        }
        for (int j : data2) {
            if (j != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    private static boolean sequenceIsPop2(int[] data1, int[] data2) {
        if (data1.length != data2.length) {
            return false;
        }
        int length = data1.length;
        for (int i = 0; i < length; i++) {
            if (data1[i] != data2[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


}
