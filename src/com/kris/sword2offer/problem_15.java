package com.kris.sword2offer;

/*
一、题目
输入两棵二叉树A和B，判断B是不是A的子结构

二、解题思路
要查找树A中是否存在和B一样的子树，我们可以分成两步：第一步在树A中找到和树B的根节点一样的节点R，第二步再判断树A中已R为根节点的子树是不是包含和树B一样的结构
 */
public class problem_15 {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean result = false;
        if (root1.value == root2.value) {
            result = match(root1, root2);
        }
        if (result) {
            return true;
        }
        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    private static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.value == root2.value) {
            return match(root1.left, root1.left) && match(root1.right, root2.right);
        }
        return false;
    }

}
