package com.kris.leetcode;

/*
给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
*/

public class leetcode_148_排序链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 7, 5, 2, 1, 6};
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }

        sortList(head);
    }

    private static ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private static void quickSort(ListNode start, ListNode end) {
        if (start != end) {
            ListNode middle = partion(start, end);
            quickSort(start, middle);
            quickSort(middle.next, end);
        }
    }

    private static ListNode partion(ListNode start, ListNode end) {
        ListNode p1 = start, p2 = start.next;
        while (p2 != end) {
            if (p2.val < start.val) {
                p1 = p1.next;

                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        if (p1 != start) {
            int tmp = p1.val;
            p1.val = start.val;
            start.val = tmp;
        }
        return p1;
    }

    private static ListNode sortList1(ListNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));

    }
    private static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }


    private static ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
        //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        // 比较链表中的值
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // 第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        // 第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }

}
