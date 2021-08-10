package com.kris.sword2offer;

/*
一、题目
写一个函数，输入n，求斐波那契数列的第n项值
斐波那契数列的定义如下：
F0 = 0，F1 = 1，Fn = Fn-1 + Fn-2

二、解题思路
按照上述递推式，可以使用循环或递归的方式获取第n项式。
 */
public class problem_07 {

    /**
     * 写一个函数，输入n，求斐波那契数列(Fibonacci)的第n项值
     * @param n     Fibonacci数的项数
     * @return      第n项的结果
     */
    public static long Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 第n-2个Fibonacci的值
        long prePre = 1;
        // 第n-1个Fibonacci的值
        long pre = 1;
        // 第n个Fibonacci的值
        long cur = 2;

        for (int i = 3; i < n; i++) {
            // 求第i个Fibonacci的值
            cur = pre + prePre;
            // 更新记录的结果， prePre原先记录第i-2个Fibonacci的值
            // 现在记录第i-1个Fibonacci的值
            prePre = pre;
            // 更新记录的结果， pre原先记录第i-1个Fibonacci的值
            // 现在记录第i个Fibonacci的值
            pre = cur;
        }
        return cur;
    }
}
