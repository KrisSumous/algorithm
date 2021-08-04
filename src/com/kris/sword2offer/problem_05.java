package com.kris.sword2offer;

import java.util.Stack;

/*
一、题目
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入结点和队列头部删除结点的功能。

二、解题思路
栈1用于存储元素，栈2用于弹出元素，负负得正。
说的通俗一点，现在把数据1、2、3分别压入栈一，然后从栈一中出来（3、2、1），放到栈二中，那么从栈二中出来的数据（1、2、3）就符合队列的规律了。
 */
public class problem_05 {

    public static class MList<T> {
        // 插入栈， 只用于插入的数据
        private Stack<T> stack1 = new Stack<>();
        // 弹出栈， 只用于弹出数据
        private Stack<T> stack2 = new Stack<>();


        public void appendTail(T t) {
            stack1.push(t);
        }

        public T deleteHead() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("no more element");
            }
            return stack2.pop();
        }
    }
}
