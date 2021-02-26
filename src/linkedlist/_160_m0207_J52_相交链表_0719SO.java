package linkedlist;

/***
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class _160_m0207_J52_相交链表_0719SO {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            if (A != null) //如果写A.next!=null就超时了
                A = A.next;
            else A = headB;
            if (B != null)
                B = B.next;
            else B = headA;
        }
//        用三元表达式替代 耗时略微增加
//        while(A != B){
//            A = A == null ? headB : A.next;
//            B = B == null ? headA : B.next;
//        }
        return A;
    }
}
