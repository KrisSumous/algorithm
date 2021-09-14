package com.kris.sword2offer;


import java.util.Stack;

/*
一、题目
定义栈的数据结构，请在该类型中实现一个能得到栈的最小数的min函数。在该栈中，调用min、push、pop的时间复杂度都是O(1)

二、解题思路
把每次的最小元素（之前的最小元素和新压入栈的元素的较小值）都保存起来放到另一个辅助栈里面。
如果每次都是把最小元素压入辅助栈，那么就能保证辅助栈的栈顶一直都是最小元素，当最小元素从数据栈中被弹出以后，
同时弹出辅助栈的栈顶元素，此时辅助栈的新栈顶元素就是下一个最小值。
 */
public class problem_18 {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();    // 辅助栈：栈顶永远保存stack中当前最小的元素

    public void push(int data) {
        stack.push(data);

        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.add(minStack.peek());
        }
    }

    public int pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("栈中为空");
        }
        int data = stack.pop();
        minStack.pop();
        return data;
    }

    public int min() throws Exception {
        if (minStack.size() == 0) {
            throw new Exception("栈中为空");
        }
        return minStack.peek();
    }

}
