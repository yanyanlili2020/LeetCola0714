package linkedlist;

/***
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class _61_旋转链表_0723M {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0) return head;
		ListNode curr = head;
		int size;
		for(size = 1; curr.next != null; size++) curr = curr.next;
		k = k % size;
		if(k == 0) return head;// 注释掉这行变为0%
		curr.next = head;// 成环
		curr = head;
		for(int i = 1; i < size - k; i++) curr = curr.next;
		head = curr.next;
		curr.next = null;
		return head;
	}
}


