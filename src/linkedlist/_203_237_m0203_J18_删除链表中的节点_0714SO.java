package linkedlist;

/***
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的节点（第二个），那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的节点（第三个），那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 说明:
 *     链表至少包含两个节点。
 *     链表中所有节点的值都是唯一的。
 *     给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 *     不要从你的函数中返回任何结果。
 */

/***
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */

public class _203_237_m0203_J18_删除链表中的节点_0714SO {
    // 237 无返回 所有节点唯一
    public void deleteNode(ListNode node) {// 传入要删除的节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
    // JOffer18 203 返回链表
    public ListNode deleteNode2(ListNode head, int val) {// 传入头节点和要删除的数值
        //定义哨兵节点，目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        //初始化两个指针 slow指向前驱节点 fast指向头节点
        ListNode slow = sentinel;
        ListNode fast = head;
        while (fast != null) {//当前节点不为空
            if (fast.val == val) //当前节点就是要删除的节点
                slow.next = fast.next;//跳过当前节点
            else slow = fast;
            fast = fast.next;//遍历下一个元素
        }
        return sentinel.next;//返回哨兵指向的next 即head
    }
    class Solution {
        // 单指针
        public ListNode removeElements(ListNode head, int val) {
            ListNode sentinel = new ListNode(0);
            sentinel.next = head;
            ListNode slow = sentinel;
            while (slow.next!=null){
                if(slow.next.val==val){
                    slow.next= slow.next.next;
                }
                else slow =slow.next;
            }
            return sentinel.next;
        }
    }
}