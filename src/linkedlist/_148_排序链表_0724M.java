package linkedlist;

/***
 * https://leetcode-cn.com/problems/sort-list/
 */

public class _148_排序链表_0724M {
	// 慢
	class Solution1 {
		public ListNode sortList(ListNode head) {
			// 1、递归结束条件
			if(head == null || head.next == null) {
				return head;
			}
			// 2、找到链表中间节点并断开链表 & 递归下探
			ListNode midNode = middleNode(head);
			ListNode rightHead = midNode.next;
			midNode.next = null;
			ListNode left = sortList(head);
			ListNode right = sortList(rightHead);
			// 3、当前层业务操作（合并有序链表）
			return mergeTwoLists(left, right);
		}
		//  找到链表中间节点（876. 链表的中间结点）
		private ListNode middleNode(ListNode head) {
			if(head == null || head.next == null) {
				return head;
			}
			ListNode slow = head;
			ListNode fast = head.next.next;
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

		// 合并两个有序链表（21. 合并两个有序链表）
		private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode sentry = new ListNode(-1);
			ListNode curr = sentry;
			while(l1 != null && l2 != null) {
				if(l1.val < l2.val) {
					curr.next = l1;
					l1 = l1.next;
				} else {
					curr.next = l2;
					l2 = l2.next;
				}
				curr = curr.next;
			}
			curr.next = l1 != null ? l1 : l2;
			return sentry.next;
		}
	}
	// 快
	class Solution2 {
		public ListNode sortList(ListNode head) {
			ListNode lead = new ListNode(0);
			lead.next = head;
			help(lead, null);
			return lead.next;
		}
		public void help(ListNode prebegin, ListNode afterend) {
			if(prebegin == null || prebegin.next == null)
				return;
			if(prebegin == afterend || prebegin.next == afterend || prebegin.next.next == afterend)
				return;
			ListNode small = new ListNode(0), small_temp = small;
			ListNode mid = new ListNode(0), mid_temp = mid;
			ListNode lager = new ListNode(0), lager_temp = lager;
			ListNode flag = prebegin.next;
			ListNode temp = prebegin.next.next;
			while(temp != afterend) {
				if(temp.val < flag.val) {
					small_temp.next = temp;
					small_temp = small_temp.next;
					temp = temp.next;
					continue;
				}
				if(temp.val == flag.val) {
					mid_temp.next = temp;
					mid_temp = mid_temp.next;
					temp = temp.next;
					continue;
				}
				if(temp.val > flag.val) {
					lager_temp.next = temp;
					lager_temp = lager_temp.next;
					temp = temp.next;
					continue;
				}
			}
			mid_temp.next = flag;
			mid_temp = flag;
			if(small.next != null && lager.next != null) {
				prebegin.next = small.next;
				small_temp.next = mid.next;
				mid_temp.next = lager.next;
				lager_temp.next = afterend;
				help(prebegin, small_temp.next);
				help(mid_temp, afterend);
				return;
			}
			if(small.next == null && lager.next == null) {
				prebegin.next = mid.next;
				mid_temp.next = afterend;
				return;
			}
			if(small.next == null) {
				prebegin.next = mid.next;
				mid_temp.next = lager.next;
				lager_temp.next = afterend;
				help(mid_temp, afterend);
				return;
			}
			if(lager.next == null) {
				prebegin.next = small.next;
				small_temp.next = mid.next;
				mid_temp.next = afterend;
				help(prebegin, small_temp.next);
			}
		}
	}
}
