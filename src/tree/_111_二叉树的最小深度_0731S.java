package tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_二叉树的最小深度_0731S {
	/**
	 * 1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
	 * 2.如果都不为空，返回较小深度+1
	 */
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		int m1 = minDepth(root.left);
		int m2 = minDepth(root.right);
		return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
	}

	public int minDepth2(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int height = 1;
		int levelCount = 1;
		while(root != null) {

			TreeNode node = queue.poll();
			// 访问node后 levelCount--
			levelCount--;

			if(node.left == null && node.right == null) return height;
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			if(levelCount == 0) {
				//如果等于0 则代表该层已经访问完了
				levelCount = queue.size();
				height++;
			}
		}
		return height;
	}
}
