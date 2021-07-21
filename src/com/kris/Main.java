package com.kris;

import com.kris.queue.ArrayQueue;
import com.kris.tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(11);
        binarySearchTree.add(3);
        binarySearchTree.add(12);
        binarySearchTree.add(17);
        binarySearchTree.add(4);
        binarySearchTree.add(18);
        binarySearchTree.add(1);
        binarySearchTree.add(6);


        binarySearchTree.postOrder();
    }
}
