package com.kris.sword2offer;

import java.util.Stack;

/*
一、题目
输入一个链表的头节点，从尾到头反过来打印每个节点的值。

二、解题思路
使用栈的方式进行。
将链表从头到尾压入栈中，出栈的过程就对应着从尾到头。

三、解题代码
 */
public class problem_03 {

    public static class ListNode {
        int value; // 节点的值
        ListNode next; // 下一个节点

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        printListInverselyUsingIteration(root);
    }

    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }
}
