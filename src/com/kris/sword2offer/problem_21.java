package com.kris.sword2offer;

/*
一、题目
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。

二、解题思路
在后序遍历得到的序列中， 最后一个数字是树的根结点的值。数组中前面的数字可以分为两部分：
第一部分是左子树结点的值，它们都比根结点的值小： 第二部分是右子树结点的值，它们都比根结点的值大。
 */
public class problem_21 {

    public static void main(String[] args) {
        boolean result = verifySequenceOfBST(new int[]{1, 3, 5, 6, 11, 15, 13, 7});
        System.out.println(result);
    }

    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        } else if (sequence[start] > sequence[end]) {
            return false;
        }
        int middle = getMiddle(sequence, start, end);
        return verifySequenceOfBST(sequence, start, middle - 1) && verifySequenceOfBST(sequence, middle, end - 1);
    }

    private static int getMiddle(int[] sequence, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            if (sequence[i] >= sequence[end]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
