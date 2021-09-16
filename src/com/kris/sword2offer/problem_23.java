package com.kris.sword2offer;

/*
#### 一、题目

请实现函数ComplexListNode clone(ComplexListNode head),复制一个复杂链表。在复杂链表中，每个结点除了有一个next 域指向下一个结点外，
还有一个sibling 指向链表中的任意结点或者null。

#### 二、解题思路

在不用辅助空间的情况下实现O(n)的时间效率。
第一步：仍然是根据原始链表的每个结点N 创建对应的N’。把N’链接在N的后面。

第二步：设置复制出来的结点的sibling。假设原始链表上的N的sibling指向结点S，那么其对应复制出来的N’是N的next指向的结点，同样S’也是S的next指向的结点。

第三步：把这个长链表拆分成两个链表。把奇数位置的结点用next . 链接起来就是原始链表，把偶数位置的结点用next 链接起来就是复制 出来的链表。
 */
public class problem_23 {

    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    public static ComplexListNode clone(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        // 先复制节点
        cloneNodes(head);
        // 再链接sibling字段
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头节点
        return reconnectNode(head);
    }

    private static void cloneNodes(ComplexListNode head) {
        while (head != null) {
            ComplexListNode tmp = new ComplexListNode();
            tmp.value = head.value;
            tmp.next = head.next;
            head.next = tmp;

            head = tmp.next;
        }
    }

    private static void connectNodes(ComplexListNode head) {
        while (head != null) {
            if (head.sibling != null) {
                head.next.sibling = head.sibling.next;
            }
            head = head.next.next;
        }
    }

    private static ComplexListNode reconnectNode(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        ComplexListNode newHead = head.next;
        ComplexListNode pointer = newHead;

        head.next = newHead.next;
        while (head != null) {
            pointer.next = head.next;
            pointer = pointer.next;
            head.next = pointer.next;
            head = pointer.next;
        }
        return newHead;
    }


}
