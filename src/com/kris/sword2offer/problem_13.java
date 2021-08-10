package com.kris.sword2offer;

/*
一、题目
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

二、解题思路
① 遍历。将指向下一个节点的指针指向上一个节点

② 递归。先让指向下一个节点的指针为空，然后递归调用，最后再将指向下一个节点的指针指向上一个节点。
 */
public class problem_13 {

    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode reverseHead(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        head = pre;
        return head;
    }


    public static ListNode reverseByRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        ListNode reverseRest = reverseHead(nextNode);
        nextNode.next = head;
        return reverseRest;
    }

}
