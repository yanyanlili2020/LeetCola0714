package linkedlist;

/***
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 * 限制：0 <= 节点个数 <= 5000
 */
public class _206_J24_反转链表_0714SO {
    //solution1 头插法 O
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = null;// 建立一个新的节点 指向null
        while(head != null) {
            ListNode tmp = head.next;//存之前的next
            head.next = newHead;
            newHead = head;
            head = tmp;//指向之前的next
        }
        return newHead;
    }
    //solution2 递归 X
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);//定义节点的next作为新的头节点
        head.next.next = head;//让当前结点的下一个结点的 next指针指向当前节点
        head.next = null;//当前结点的 next指针指向 NULL
        return newHead;//返回新的头节点 即新的链表
    }
}
