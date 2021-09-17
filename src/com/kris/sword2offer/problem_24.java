package com.kris.sword2offer;

/*
#### 一、题目

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

#### 二、解题思路

在二叉树中，每个结点都有两个指向子结点的指针。在双向链表中，每个结点也有两个指针，它们分别指向前一个结点和后一个结点。
由于这两种结点的结构相似，同时二叉搜索树也是一种排序的数据结构，因此在理论上有可能实现二叉搜索树和排序的双向链表的转换。

在搜索二叉树中，左子结点的值总是小于父结点的值，右子结点的值总是大于父结点的值。因此我们在转换成排序双向链表时，
原先指向左子结点的指针调整为链表中指向前一个结点的指针，原先指向右子结点的指针调整为链表中指向后一个结点指针。接下来我们考虑该如何转换。

由于要求转换之后的链表是排好序的，我们可以中序遍历树中的每一个结点， 这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。
当遍历到根结点的时候，我们把树看成三部分：根结点，左子树，右子树。
根据排序链表的定义，根结点将和它的左子树的最大一个结点链接起来，同时它还将和右子树最小的结点链接起来。
 */

import java.util.Stack;

/*
                 6
               /  \
              4    9
             / \  / \
            3  5 7  10
 */
public class problem_24 {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(9, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(4, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(6, node2, node3);

        convert(node1);
    }

    public static class BinaryTreeNode {
        
        public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        // 为什么要用二级指针
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        convertNode(root, lastNode);

        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void convertNode(BinaryTreeNode root, BinaryTreeNode[] lastNode) {
        if (root != null) {
            if (root.left != null) {
                convertNode(root.left, lastNode);
            }
            root.left = lastNode[0];

            if (lastNode[0] != null) {
                lastNode[0].right = root;
            }

            lastNode[0] = root;

            if (root.right != null) {
                convertNode(root.right, lastNode);
            }
        }
    }

}
