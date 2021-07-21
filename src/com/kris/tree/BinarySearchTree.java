package com.kris.tree;

import com.kris.array.Array;
import com.kris.stack.ArrayStack;
import com.kris.stack.Stack;

// 二分搜索树
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加一个元素
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    // 二分搜索树中是否包含元素E
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrderNoRecursion(root);
    }

    // 前序遍历递归
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 前序遍历 非递归
    private void preOrderNoRecursion(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new ArrayStack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder() {
        inOrderNoRecursion(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void inOrderNoRecursion(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new ArrayStack<>();
        Node pop = node;
        while (!stack.isEmpty() || pop != null) {
            while (pop != null) {
                stack.push(pop);
                pop = pop.left;
            }
            Node pop1 = stack.pop();
            System.out.println(pop1.e);

            pop = pop1.right;

        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private void postOrderNoRecursion(Node node) {
        if (node == null) {
            return;
        }
        Node pre = null;
        Node node1 = node;
        Stack<Node> stack = new ArrayStack<>();

        while (!stack.isEmpty() || node1 != null) {
            while (node1 != null) {
                stack.push(node1);
                node1 = node1.left;
            }
            Node node2 = stack.peek();
            if (node2.right == null || pre == node2.right) {
                stack.pop();
                pre = node2;
                System.out.println(node2.e);
            } else {
                node1 = node2.right;
            }
        }

    }

}
