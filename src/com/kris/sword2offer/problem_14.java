package com.kris.sword2offer;

/*
一、题目
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是按照递增排序的。

二、解题思路
step1. 定义一个指向新链表的指针，暂且让它指向NULL
step2. 比较两个链表的头节点，让较小的头节点作为新链表的头节点
step3. 有两种方法
① 递归比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点
② 循环比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点。直到有一个链表没有节点，然后将新链表的最后一个节点直接指向剩余链表的节点。
 */
public class problem_14 {

    public static void main(String[] args) {

    }

    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode root = new ListNode();
        ListNode pointer = root;

        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head1.next;
            }
            pointer = pointer.next;
        }

        if (head1 != null) {
            pointer.next = head1;
        }

        if (head2 != null) {
            pointer.next = head2;
        }
        return root.next;
    }

    public static ListNode merge2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode tmp = head1;
        if (tmp.value < head2.value) {
            tmp.next = merge2(head1.next, head2);
        } else {
            tmp = head2;
            tmp.next = merge2(head1, head2.next);
        }
        return tmp;
    }
}
