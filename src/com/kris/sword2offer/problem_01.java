package com.kris.sword2offer;

/*
一、题目
在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含该证书

二、解题思路
首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
如果该数字大于要查找的数字，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行。
也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围内剔除一行或一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。

*/

public class problem_01 {

    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 2, 4}, {2, 4, 8}, {3, 6, 9}};
        boolean result = find(data, 7);
        System.out.println(result);
    }

    public static boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0; // 起始开始的行数
        int col = cols - 1; // 起始开始的列数
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == number) {
                return true; // 如果找到了直接退出
            } else if (matrix[row][col] > number) {
                col--; // 如果找到的数比要找的数要大，说明要找的数在当前数的左边
            } else {
                row++; // 如果找到的数比要找的数小，说明要找的数在当前数的下边
            }
        }
        return false;
    }

}
