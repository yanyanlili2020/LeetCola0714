package linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/***
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class _J06_从尾到头打印链表_0718S {
    // solution1 用链表构建栈 1ms
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = stack.removeLast();
        return result;
    }
    // solution2 栈 2ms
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] result = new int[size];// 建立数组 准备输出
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
    // solution3 数组 0ms
    public int[] reversePrint3(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int[] result = new int[length];
        cur = head;
        int pos = length - 1;
        while (cur != null) {
            result[pos --] = cur.val;
            cur = cur.next;
        }
        return result;
    }
}
