package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/***
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 使用栈实现队列的下列操作：
 *     push(x) -- 将一个元素放入队列的尾部。
 *     pop() -- 从队列首部移除元素。
 *     peek() -- 返回队列首部的元素。
 *     empty() -- 返回队列是否为空。
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *     你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *     假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class _232_m0304_JOffer09_用栈实现队列_0715S {
    // 13ms
    class MyQueue {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!outStack.empty()){
                inStack.push(outStack.pop());
            }
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!inStack.empty()){
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (!inStack.empty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.empty();
        }
    }
    /***
     * JOffer09
     * 用两个栈实现一个队列。
     * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分
     * 别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    class CQueue {
        Deque<Integer> stack1= new LinkedList<Integer>();
        Deque<Integer> stack2= new LinkedList<Integer>();
        public CQueue() {}
        public void appendTail(int value) {
            stack1.push(value);
        }
        public int deleteHead() {
            // 如果第二个栈为空
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                int deleteItem = stack2.pop();
                return deleteItem;
            }
        }
    }
}
