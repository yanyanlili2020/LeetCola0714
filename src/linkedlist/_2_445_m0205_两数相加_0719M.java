package linkedlist;

import java.util.Stack;

/***
 * https://leetcode-cn.com/problems/add-two-numbers/
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class _2_445_m0205_两数相加_0719M {
    class _2_m0205 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode sentinel = new ListNode(0);
            ListNode curr = sentinel;
            int carry = 0;
            while(l1 != null || l2 != null) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            if(carry > 0) curr.next = new ListNode(carry);
            return sentinel.next;
        }
    }
    class _445 {
        class Solution1 {
            public ListNode addTwoNumbers (ListNode l1, ListNode l2){
                Stack<Integer> stack1 = new Stack<>();
                Stack<Integer> stack2 = new Stack<>();
                while(l1 != null) {
                    stack1.push(l1.val);
                    l1 = l1.next;
                }
                while(l2 != null) {
                    stack2.push(l2.val);
                    l2 = l2.next;
                }
                int carry = 0;
                ListNode head = null;
                while(!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
                    int sum = carry;
                    sum += stack1.isEmpty() ? 0 : stack1.pop();
                    sum += stack2.isEmpty() ? 0 : stack2.pop();
                    ListNode node = new ListNode(sum % 10);
                    node.next = head;// 头插法
                    head = node;
                    carry = sum / 10;
                }
                return head;
            }
        }
        // Solution 反转链表 再求和 再反转
        class solution2 {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                if(l1 == null) return l2;
                if(l2 == null) return l1;
                ListNode l1_reverse = reverse(l1);
                ListNode l2_reverse = reverse(l2);
                ListNode res = new ListNode(0);
                ListNode head = res;
                int tmp = 0;
                //add(l1,l2,res,tmp);
                while(l1_reverse != null || l2_reverse != null) {
                    int a = l1_reverse == null ? 0 : l1_reverse.val;
                    int b = l2_reverse == null ? 0 : l2_reverse.val;
                    int sum = a + b + tmp;
                    tmp = sum / 10;
                    res.next = new ListNode(sum % 10);
                    res = res.next;
                    if(l1_reverse != null) l1_reverse = l1_reverse.next;
                    if(l2_reverse != null) l2_reverse = l2_reverse.next;
                    //if(tmp==0 && l1==null&&l2==null)break;
                }
                if(tmp > 0) res.next = new ListNode(tmp);
                return reverse(head.next);
                //ListNode ans =reverse(head);
                //return ans.val==0?ans.next:ans;
            }
            public ListNode reverse(ListNode head) {
                ListNode pre = null;
                while(head != null) {
                    ListNode tmp = head.next;
                    head.next = pre;
                    pre = head;
                    head = tmp;
                }
                return pre;
            }
        }
    }
}
