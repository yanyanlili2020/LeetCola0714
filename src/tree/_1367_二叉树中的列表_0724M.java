package tree;

/**
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class _1367_二叉树中的列表_0724M {
	public boolean isSubPath(ListNode head, TreeNode root) {
		if(head == null) return true;
		if(root == null) return false;
		//先判断当前的节点，如果不对，再看左子树和右子树
		return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}
	private boolean isSub(ListNode head, TreeNode node) {
		//链表走完了
		if(head == null) return true;
		//链表没走完，树走完了
		if(node == null) return false;
		//如果值不同
		if(head.val != node.val) return false;
		//如果值相同，继续对比,左边和右边有一个满足即可
		return isSub(head.next, node.left) || isSub(head.next, node.right);
	}
}
