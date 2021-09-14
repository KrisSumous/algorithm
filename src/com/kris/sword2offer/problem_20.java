package com.kris.sword2offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
一、题目
从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。

二、解题思路
这道题实质是考查树的遍历算法。从上到下打印二叉树的规律：每一次打印一个结
点的时候，如果该结点有子结点， 则把该结点的子结点放到一个队列的末尾。接下
来到队列的头部取出最早进入队列的结点，重复前面的打印操作，直至队列中所有
的结点都被打印出来为止。
 */
public class problem_20 {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void printFromToBottom1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void printFromToBottom2(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        Queue<BinaryTreeNode> queue1 = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                BinaryTreeNode node = queue.poll();
                System.out.print(node.value + ",");
                if (node.left != null) {
                    queue1.offer(node.left);
                }
                if (node.right != null) {
                    queue1.offer(node.right);
                }
            }
            System.out.println();
            while (!queue1.isEmpty()) {
                queue.offer(queue1.poll());
            }
        }
    }

}
