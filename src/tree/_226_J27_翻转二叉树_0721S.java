package tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * https://leetcode-cn.com/problems/invert-binary-tree
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class _226_J27_翻转二叉树_0721S {
	class Solution1 {
		/* 递归	*/
		public TreeNode invertTree(TreeNode root) {
			if ( root == null ) return null;// 空树
			TreeNode right = invertTree(root.right);// 递归交换当前节点的 右子树
			TreeNode left = invertTree(root.left);// 递归交换当前节点的 左子树
			root.left = right;// 右子树作为根的左子树
			root.right = left;// 左子树作为根的右子树
			return root;
		}

	}

	class Solution2 {
		/* 迭代 */
		public TreeNode invertTree(TreeNode root) {
			if ( root == null ) return null;// 判断根结点是否为空，为空则返回null
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);// 新建栈（队列），用于节点存储，初始存入根节点到栈（队列）里
			while ( !queue.isEmpty() ) {// 栈（队列）为空时结束循环
				TreeNode curr = queue.poll();//每次都从队列中拿一个节点
				//交换这个节点的左右子树
				TreeNode temp = curr.left;
				curr.left = curr.right;
				curr.right = temp;
				//如果当前节点的子树不为空，则放入队列等待后续处理
				if ( curr.left != null ) queue.add(curr.left);
				if ( curr.right != null ) queue.add(curr.right);
			}
			return root;
		}
	}
}
