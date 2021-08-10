package com.kris.sword2offer;

/*
一、题目
给定单项链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点

二、解题思路
由于给定了节点指针，那么要删除该节点。只要把该节点的值替换为下一个节点的值。同时让该节点直接指向下一个节点的下一个节点。相当于顶包替代了下一个节点，该节点自然不存在。
需要注意的是如果制定节点是头节点，那么直接把头节点定义为下一个节点即可。如果是尾节点，需要循环遍历到该节点，然后让尾节点的上一个节点的指针为空即可
 */
public class problem_10 {

    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        // 如果输入参数有空值就返回链表头节点
        if (head == null || toBeDeleted == null) {
            return head;
        }
        // 如果删除的是头节点，直接返回头节点的下一个节点
        if (head == toBeDeleted) {
            return head.next;
        }
        // 下面的情况至少有两个节点
        // 在多个节点的情况下，如果删除的最后一个元素
        if (toBeDeleted.next == null) {
            ListNode tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            // 删除该节点
            tmp.next = null;
        } else  {
            // 在多个节点的情况下，如果删除的是某个中间节点
            // 将下一个节点的值输入当前待删除的节点
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }

 }
