package com.kris.sword2offer;


/*

一、题目
请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则 输出“We%20are%20happy.”。

二、解题思路
先判断字符串中空格的数量。根据数量判断该字符串有没有足够的空间替换 成"%20"。
如果有足够空间，计算出需要的空间。根据最终需要的总空间，维护一个指针在最后。从后到前，遇到非空的就把该值挪到指针指向的位置，然后指针向前一位，遇到“ ”，则指针前移，依次替换为“02%”。

三、解题代码
 */
public class problem_02 {

    public static void main(String[] args) {
        char[] data = new char[30];
        String str = "we are happy";
        for (int i = 0; i < str.length(); i++) {
            data[i] = str.charAt(i);
        }
        System.out.println(replaceBlank(data, 12));
    }

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * @param str        要转换的字符数组
     * @param usedLength 已经字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public static int replaceBlank(char[] str, int usedLength) {
        // 判断输入是否合法
        if (str == null || str.length < usedLength) {
            return -1;
        }
        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (str[i] == ' ') {
                whiteCount++;
            }
        }
        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength;
        if (targetLength > str.length) {
            // 如果转化后的长度大于数组的最大长度， 直接返回失败
            return -1;
        }
        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }
        usedLength--; // 由后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如果当前字符是空白字符，用%20替换
            if (str[usedLength] == ' ') {
                str[targetLength--] = '0';
                str[targetLength--] = '2';
                str[targetLength--] = '%';
            } else {
                str[targetLength--] = str[usedLength];
            }
            usedLength--;
        }
        return tmp;
    }
}
