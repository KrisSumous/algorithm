package com.kris.sword2offer;

/*
一、题目
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点，
例如一个链表有6个节点，从头节点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第三个节点是值为4的节点。

二、解题思路
为了实现只遍历链表一次就能找到倒数第k个节点，我们可以定义两个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；
从第k步开始，第二指针也开始从链表的头指针开始遍历。由于两个指针的距离始终保持在k-1，当第一个指针到达链表的尾节点时，第二个指针正好是倒数第k个节点。
 */
public class problem_12 {

    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode findKthToTail(ListNode head, int k) {
        if (k < 1 || head == null) {
            return null;
        }
        ListNode pointer = head;
        for (int i = 1; i < k; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return null;
            }
        }
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }
        return head;
    }
}
