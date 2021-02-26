package linkedlist;

/***
 * https://leetcode-cn.com/problems/partition-list/
 */

public class _86_m0204_分隔链表_0723M {
	// 双指针
	public ListNode partition(ListNode head, int x) {
		ListNode before_head = new ListNode(0);
		ListNode before = before_head;
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;
		while(head != null) {
			if(head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		after.next = null;
		before.next = after_head.next;
		return before_head.next;
	}
}
