package com.kris.sword2offer;

/*
一、题目
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字

二、解题思路
把打印一圈分为四步：第一步从左到右打印一行，第二步从上到下打印一列，第三步从右到左打印一行，
第四步从下到上打印一列。每一步我们根据起始坐标和终止坐标用一个循环就能打印出一行或者一列。

不过值得注意的是，最后一圈有可能退化出只要一行或者一列，甚至只有一个数字，因此打印这样的一圈就不再需要四步。

因此我们要仔细分析打印时每一步的前提条件。第一步总是需要的，因为打印一圈至少有第一步。如果只有一行，那么就不用第二步了。
也就是需要第二步的前提条件是终止行号大于起始行号。需要第三步打印的前提条件是圈内至少有两行两列，也就是说除了要求终止行号大于起始行号之外，
还要求终止列号大于起始列号。同理需要打印第四步的条件是至少有三行两列，因此要求终止行号比起始行号至少大2，同时终止列号大于起始列号。
 */
public class problem_17 {
    public static void printMatrixClockWisely(int[][] numbers) {
        if (numbers == null) {
            return;
        }
        // 记录一圈开始位置的行
        int x = 0;
        // 记录一圈开始位置的列
        int y = 0;
        // 对每一圈进行处理
        // 行号最大是(numbers.length - 1) / 2
        // 列号最大是(numbers[0].length - 1) / 2
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            x++;
            y++;
        }
    }

    private static void printMatrixInCircle(int[][] numbers, int x, int y) {
        int rows = numbers.length;
        int cols = numbers[0].length;

        // 输出环上面的一行，包括最中的那个数字
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.println(numbers[x][i]);
        }
        // 环的高度至少为2才会输出右边的一列
        // rows - x - 1 : 表示环最下的那一行的行号
        if (rows - x - 1 > x) {
            // 因为右边那一列最上边已经被输出，所以从x+1开始
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.println(numbers[i][cols - y - 1]);
            }
        }
        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols - y - 1 : 表示环最右那一列的行号
        if (rows - x - 1 > x && cols - y - 1 > y) {
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.println(numbers[rows - x - 1][i]);
            }
        }
        // 环的宽度至少为2并且高度至少为3才会输出最左边那一列
        if (cols - y - 1 > y && rows - x - 2 > x) {
            for (int i = rows - x - 2; i >= x + 1; i--) {
                System.out.println(numbers[i][y]);
            }
        }
    }
}
