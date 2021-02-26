package linkedlist;

/***
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 返回该链表中倒数第k个节点。
 */
public class _19_删除链表的倒数第N个节点_0723M {
    class _19 {
        class Solution1 {
            // 不加哨兵节点 [1] 1 只有一个节点 删除头节点 会报空指针
            public ListNode removeNthFromEnd(ListNode head, int n) {
                ListNode sentinel = new ListNode(0);
                sentinel.next = head;
                ListNode fast = sentinel;
                ListNode slow = sentinel;
                // 注意这里的等于 因为加了哑结点 所以需要多移动一个
                for(int i = 0; i <= n; i++) fast = fast.next;
                // 如果不用哑结点 加下一句 用于删除头节点的情况
                // if(fast==null) return head.next;
                while(fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
                return sentinel.next;
            }
        }
        // [1] 2 上面会报错 下面不会
        class Solution2 {
            public ListNode removeNthFromEnd2(ListNode head, int n) {
                int count = 0;
                ListNode fast = head;
                ListNode slow = head;
//		注释掉后可正常ac
//		if (head.next == null) {// 如果head 的next 为空 即为空链表
//			head = null;// head指向空
//			return head;// 返回head
//		}
//		if (head.next.next == null) {// 如果head的next 的next为空 即只有一个节点
//
//			if (n == 2) return head.next;// 删除倒数第2个的话
//			if (n == 1) {// 删除到户第1个节点的话
//				head.next = null;
//				return head;
//			}
//		}
                while(fast.next != null) {
                    count++;
                    fast = fast.next;
                    if(count <= n) continue;
                    else slow = slow.next;
                }
                if(count < n) return head.next;
                slow.next = slow.next.next;
                return head;
            }
        }
    }
    class _m0202_JOffer22 {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            for(int i = 0; i < k; i++)
                fast = fast.next;
            while(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
            // 返回 倒数第k个元素 _m0202_
            //return slow.val;
        }
    }
}
