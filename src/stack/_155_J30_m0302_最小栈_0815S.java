package stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * https://leetcode-cn.com/problems/min-stack-lcci/
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class _155_J30_m0302_最小栈_0815S {
    class Solution19ms {
        class MinStack {
            Node currentNode;
            Node minNode;
            public MinStack() {
                this.currentNode = null;
                this.minNode = new Node(Integer.MAX_VALUE, null, null);
            }
            public void push(int x) {
                Node node = new Node(x, this.currentNode, null);
                if(x <= this.minNode.val) {
                    node.nextMinNode = this.minNode;
                    this.minNode = node;
                }
                node.next = this.currentNode;
                this.currentNode = node;
            }
            public void pop() {
                if(this.minNode.val == this.currentNode.val) {
                    this.minNode = this.minNode.nextMinNode;
                }
                this.currentNode = this.currentNode.next;
            }
            public int top() {
                return this.currentNode.val;
            }
            public int getMin() {
                return this.minNode.val;
            }
            class Node {
                int val;
                Node next;
                Node nextMinNode;
                public Node(int val, Node next, Node nextMinNode) {
                    this.val = val;
                    this.next = next;
                    this.nextMinNode = nextMinNode;
                }
            }
        }
    }
    class Solution23ms {
        public class MinStack {
            // 数据栈
            private Stack<Integer> data;
            // 辅助栈
            private Stack<Integer> helper;
            /**
             * initialize your data structure here.
             */
            public MinStack() {
                data = new Stack<>();
                helper = new Stack<>();
            }
            // 思路 1：数据栈和辅助栈在任何时候都同步
            public void push(int x) {
                // 数据栈和辅助栈一定会增加元素
                data.add(x);
                if(helper.isEmpty() || helper.peek() >= x) {
                    helper.add(x);
                }
                else {
                    helper.add(helper.peek());
                }
            }
            public void pop() {
                // 两个栈都得 pop
                if(!data.isEmpty()) {
                    helper.pop();
                    data.pop();
                }
            }
            public int top() {
                if(!data.isEmpty()) {
                    return data.peek();
                }
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
            public int getMin() {
                if(!helper.isEmpty()) {
                    return helper.peek();
                }
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
        }
    }
    class Solution1 {
        class MinStack {
            int min = Integer.MAX_VALUE;
            private Stack<Integer> stack;
            /**
             * initialize your data structure here.
             */
            public MinStack() {
                stack = new Stack<>();// 用栈实现最小栈
            }
            public void push(int x) {// 入栈 如果
                if(x <= min) {
                    stack.push(min);
                    min = x;
                }
                stack.push(x);
            }
            // public void push(int x) {// 入栈 如果
            //     stack.push(x);
            //     if(x <= min){// 错 还不知道为啥错
            //     min = x;
            //     }
            // }
            public void pop() {
                if(stack.pop() == min) {
                    min = stack.pop();
                }
            }
            public int top() {// 返回栈顶元素
                return stack.peek();
            }
            public int getMin() {// 返回最小值
                return min;
            }
        }
    }
}
