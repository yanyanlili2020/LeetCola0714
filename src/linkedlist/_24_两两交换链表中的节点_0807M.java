package linkedlist;

public class _24_两两交换链表中的节点_0807M {
    class Solution1 {
        /*
        返回值：交换完成的子链表
        调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
        终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
         */
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
    }
    
    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            ListNode sentinel = new ListNode(0);
            sentinel.next = head;
            ListNode temp = sentinel;
            while(temp.next != null && temp.next.next != null) {
                ListNode start = temp.next;
                ListNode end = temp.next.next;
                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return sentinel.next;
        }
    }
}
