package tree;

/***
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * https://leetcode-cn.com/problems/check-balance-lcci/
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class _110_JOffer55II_m0404_平衡二叉树_0731S {
	class Solution1 {
		// 计算树的高度, 根为空 返回-1 , 否则 返回 1 + 左子树和右子树的高度的大值
		private int height(TreeNode root) {
			if(root == null) return -1;
			return 1 + Math.max(height(root.left), height(root.right));
		}
		
		public boolean isBalanced(TreeNode root) {
			if(root == null) return true;
			// 如果左右子树的高度差小于2,检查左右子树是否为平衡树
			return Math.abs(height(root.left) - height(root.right)) < 2
					&& isBalanced(root.left)
					&& isBalanced(root.right);
		}
	}
	class Solution2 {
		/**
		 * recur(root):
		 *     递归返回值：
		 *         当节点 root 左 / 右子树的高度差 <2 ：则返回以节点root为根节点的子树的最大高度，
		 *         即节点 root 的左右子树中最大高度加 1 （ max(left, right) +1 ）；
		 *         当节点 root 左 / 右子树的高度差 ≥2 ：则返回 −1 ，代表 此子树不是平衡树 。
		 *     递归终止条件：
		 *         当越过叶子节点时，返回高度 0 ；
		 *         当左（右）子树高度 left== -1 时，代表此子树的 左（右）子树 不是平衡树，因此直接返回 −1 ；
		 * isBalanced(root) ：
		 *     返回值： 若 recur(root) != 1 ，则说明此树平衡，返回 true ； 否则返回 false 。
		 *
		 */
		public boolean isBalanced(TreeNode root) {
			return recur(root) != -1;
		}
		private int recur(TreeNode root) {
			if(root == null) return 0;
			int left = recur(root.left);
			if(left == -1) return -1;
			int right = recur(root.right);
			if(right == -1) return -1;
			return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
		}
	}
}
