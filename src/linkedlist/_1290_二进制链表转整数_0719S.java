package linkedlist;

/***
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 给你一个单链表的引用结点 head。
 * 链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * 示例 1：
 *      输入：head = [1,0,1]
 *      输出：5
 *      解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *      输入：head = [0]
 *      输出：0
 * 示例 3：
 *      输入：head = [1]
 *      输出：1
 * 示例 4：
 *      输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 *      输出：18880
 * 示例 5：
 *      输入：head = [0,0]
 *      输出：0
 * 提示：
 *     链表不为空。
 *     链表的结点总数不超过 30。
 *     每个结点的值不是 0 就是 1。
 */
public class _1290_二进制链表转整数_0719S {
    /*由于链表中从高位到低位存放了数字的二进制表示，
    因此我们可以使用二进制转十进制的方法，
    在遍历一遍链表的同时得到数字的十进制值。*/
    public int getDecimalValue(ListNode head) {
    ListNode curr = head;// 定义指针
    int result = 0;// 定义输出
    while(curr != null){
        result = result*2 + curr.val;//
        curr = curr.next;
    }
    return result;
    }
}
