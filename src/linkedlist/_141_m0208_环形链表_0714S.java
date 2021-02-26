package linkedlist;

/***
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 *给定一个链表，判断链表中是否有环。
 *为了表示给定链表中的环， 如果 pos 是 -1，则在该链表中没有环。
 *我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *示例 1：
 *		输入：head = [3,2,0,-4], pos = 1
 *		输出：true
 *		解释：链表中有一个环，其尾部连接到第二个节点。
 *进阶：
 *		你能用 O(1)（即，常量）内存解决此问题吗？如下：
 */
public class _141_m0208_环形链表_0714S {
    public class Solution141 {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;// 这里可以改为head 但是 下面的solution不能改
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
    public class Solution0208 {
        /**
         * 要返回链表成环的起点 要用到第三个指针 当成环后 用第三个指针从头开始走 当相遇时 即是环的起点
         */
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;// 如果改为head.next就 超时?
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                // 此处如果用if (slow != null && fast != null &&
                // slow.val == fast.val) 会超出时间限制
                if(slow == fast) {
                    break;
                }
            }
            if(fast == null || fast.next == null) {
                return null;
            }
            // slow从head开始，fast从相遇点开始，一步一步走再次相遇即为环入口
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
