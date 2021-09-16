package com.kris.sword2offer;

import java.util.ArrayList;
import java.util.List;

/*
#### 一、题目

输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

#### 二、解题思路

由于路径是从根结点出发到叶结点， 也就是说路径总是以根结点为起始点，因此我们首先需要遍历根结点。在树的前序、中序、后序三种遍历方式中，只有前序遍历是首先访问根结点的。
当用前序遍历的方式访问到某一结点时， 我们把该结点添加到路径上，并累加该结点的值。如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数，
则当前的路径符合要求，我们把它打印出来。如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。
因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父结点的路径。

不难看出保存路径的数据结构实际上是一个枝， 因为路径要与递归调用状态一致，而递归调用的本质就是一个压栈和出栈的过程。
 */
public class problem_22 {
    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node10, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, node8);
        BinaryTreeNode node4 = new BinaryTreeNode(4, node9, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        findPath(node1, 16);
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

    public static void findPath(BinaryTreeNode root, int expectedSum) {
        List<Integer> list = new ArrayList<>();
        findPath(root, 0, expectedSum, list);
    }

    private static void findPath(BinaryTreeNode root, int curNum, int expectedSum, List<Integer> result) {
        if (root != null) {
            curNum += root.value;
            result.add(root.value);
            if (curNum < expectedSum) {
                findPath(root.left, curNum, expectedSum, result);
                findPath(root.right, curNum, expectedSum, result);
            } else if (curNum == expectedSum) {
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }
            result.remove(result.size() - 1);
        }
    }
}
