package linkedlist;

/***
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author mosh4
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 示例 1：
 *		输入：[1,2,3,4,5]
 *		输出：此列表中的结点 3 (序列化形式：[3,4,5])
 *		返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *		输入：[1,2,3,4,5,6]
 *		输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class _876_链表的中间结点_0714S {
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;//快慢指针
		while (fast != null && fast.next != null) {//快指针和快指针.next都不为空
			slow = slow.next;//慢指针每次走一格
			fast = fast.next.next;//快指针每次走两格
		}
		return slow;//快指针到链尾时，慢指针刚好到中间
	}
}
