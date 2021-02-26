package tree;

/***
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表_0801M {
	public void flatten(TreeNode root) {
		if(root == null) return;
		//将根节点的左子树变成链表
		flatten(root.left);
		//将根节点的右子树变成链表
		flatten(root.right);
		TreeNode temp = root.right;
		//把树的右边换成左边的链表
		root.right = root.left;
		//记得要将左边置空
		root.left = null;
		//找到树的最右边的节点
		while(root.right != null) root = root.right;
		//把右边的链表接到刚才树的最右边的节点
		root.right = temp;
	}
	public void flatten2(TreeNode root) {
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left != null) {
				TreeNode next = curr.left;
				TreeNode predecessor = next;
				while(predecessor.right != null) {
					predecessor = predecessor.right;
				}
				predecessor.right = curr.right;
				curr.left = null;
				curr.right = next;
			}
			curr = curr.right;
		}
	}
}
