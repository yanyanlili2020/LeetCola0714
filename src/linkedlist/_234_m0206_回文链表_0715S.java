package linkedlist;

/***
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 *      输入: 1->2
 *      输出: false
 * 示例 2:
 *      输入: 1->2->2->1
 *      输出: true
 * 进阶：
 *      你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class _234_m0206_回文链表_0715S {
    // Solution1 0ms
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {// 如果没有数据 或 只有一个数据 返回true
            return true;
        }
        if (head.next.next == null) {// 如果只有两个数据
            return head.val == head.next.val;// 返回第一个和第二个数据是否一样
        }
        ListNode fast = head.next;// 快指针指向head的next
        ListNode slow = head;// 慢指针指向head
        while (fast.next != null) {
            if (fast.next.val == slow.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || fast.val == slow.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
    // solution2 2ms
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点
        // 反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否为回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 恢复链表
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }
    // 反转后半部分链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }// 快慢指针找中点
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
