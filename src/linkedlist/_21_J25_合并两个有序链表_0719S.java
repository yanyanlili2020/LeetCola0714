package linkedlist;

/***
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
// 建一个新列表，对比两个节点，加入新列表
public class _21_J25_合并两个有序链表_0719S {
    // solution1 迭代
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);// 设立哨兵节点 作为虚拟头节点 哑结点
        ListNode curr = sentinel;// 建立指针 指向虚拟头节点
        while (l1 != null && l2 != null) {// 如果 l1 和 l2 都不为空
            if (l1.val <= l2.val) {// 如果 l1 小于 l2 ,则 l1作为下一个节点
                curr.next = l1;
                l1 = l1.next;// l1 后移一个
            } else {// 如果 l1 大于 l2 ,则 l2作为下一个节点
                curr.next = l2;
                l2 = l2.next;// l2 后移一个
            }
            curr = curr.next;// curr 后移一个
        }// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        curr.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }

    //solution2 递归 更快
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {// l1 为空
            return l2;
        } else if (l2 == null) {// l2 为空
            return l1;
        } else if (l1.val < l2.val) {// 这时 l1 和 l2 为相应的头节点
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
