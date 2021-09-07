package com.kris.sword2offer;

/*
一、题目
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

二、解题思路
先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个字节点。当交换完所有非叶子节点的左右子节点之后，就得到了树的镜像。
 */
public class problem_16 {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void mirror(BinaryTreeNode node) {
        if (node != null) {
            BinaryTreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            // 对节点的左右两个子树进行处理
            mirror(node.left);
            mirror(node.right);
        }
    }

}
