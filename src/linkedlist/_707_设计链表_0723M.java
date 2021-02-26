package linkedlist;

/***
 * https://leetcode-cn.com/problems/design-linked-list/
 */
//单链表法
public class _707_设计链表_0723M {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class MyLinkedList {
        int size;
        ListNode head;
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }
        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode curr = head;
            for(int i = 0; i < index + 1; ++i) curr = curr.next;
            return curr.val;
        }
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            ++size;
            ListNode curr = head;
            for(int i = 0; i < index; ++i) curr = curr.next;
            ListNode node = new ListNode(val);
            node.next = curr.next;
            curr.next = node;
        }
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            size--;
            ListNode curr = head;
            for(int i = 0; i < index; ++i) curr = curr.next;
            curr.next = curr.next.next;
        }
    }
}
