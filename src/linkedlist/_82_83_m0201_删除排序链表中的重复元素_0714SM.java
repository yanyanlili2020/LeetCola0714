package linkedlist;

import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *给定一个 排序 链表，删除所有重复的元素，使得每个元素只出现一次。
 *示例 1:
 *      输入: 1->1->2
 *      输出: 1->2
 *
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * 编写代码，移除 未排序 链表中的重复节点。保留最开始出现的节点。
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class _82_83_m0201_删除排序链表中的重复元素_0714SM {
    // 因为是排序列表 所以不同的数据之后不会出现相同的数据了
    class _82 {
        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                ListNode dummy = new ListNode(0);
                dummy.next = head;
                ListNode cur = dummy;
                while(cur.next != null && cur.next.next != null) {
                    if(cur.next.val == cur.next.next.val) {
                        ListNode temp = cur.next;
                        while(temp != null && temp.next != null && temp.val == temp.next.val) {
                            temp = temp.next;
                        }
                        cur.next = temp.next;
                    }
                    else
                        cur = cur.next;
                }
                return dummy.next;
            }
        }
    }
    class _83_m0201 {
        //solution1
        public ListNode deleteDuplicates(ListNode head) {
            ListNode curr = head;//定义指向head的curr
            while(curr != null && curr.next != null) {//当前节点和 next都不为空
                if(curr.val == curr.next.val) {//如果当前节点和next节点的值相等
                    curr.next = curr.next.next;//则越过next
                }
                else {
                    curr = curr.next;//向后一个
                }
            }
            return head;//输出删除了元素的链表
        }
        //solution2 快慢指针 0 ms
        public ListNode deleteDuplicates2(ListNode head) {
            //头为空，则为空链表，返回空
            if(head == null) {
                return null;
            }
            ListNode slow = head;//慢指向头
            ListNode fast = head.next;//快指向头next
            while(fast != null) {//快不为空
                if(slow.val == fast.val) {//快慢指针的值相等，将快所指的跳过去
                    slow.next = fast.next;//慢的next指向快的next
                    fast = slow.next;//快变为慢的next，即上一行慢的next指向的
                }
                else {//快慢均向后移一个
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            return head;
        }
        // 未排序
        public ListNode removeDuplicateNodes(ListNode head) {
            // 5 ms
            if(head == null) return head;
            Set<Integer> occurred = new HashSet<>();
            occurred.add(head.val);// 将head指的值加入哈希表
            ListNode curr = head;
            // 枚举前驱节点
            while(curr.next != null) {
                // 当前待删除节点
                if(occurred.add(curr.next.val)) {// 如果prev 指的值能加入哈希表
                    curr = curr.next;//则 curr后移一个
                }
                else {
                    curr.next = curr.next.next;
                }
            }
            return head;
        }
        public ListNode removeDuplicateNodes2(ListNode head) {
            boolean[] bool = new boolean[20001];// 建立布尔数组
            // 如果头节点指向空 则为空链
            if(head == null) return head;
            ListNode curr = head;// 建立一个节点 指向链表头
            bool[curr.val] = true;// curr节点的数值作为索引 对应bool数组值true
            while(curr.next != null) {// 如果节点的next节点 不为空
                if(bool[curr.next.val]) {// 如果节点的next节点的值作为索引的值为true
                    curr.next = curr.next.next;// 后移节点
                }
                else {// 将节点的next节点的值作为索引的值 赋值为true
                    bool[curr.next.val] = true;
                    curr = curr.next;// 后移节点
                }
            }
            return head;
        }
    }
}