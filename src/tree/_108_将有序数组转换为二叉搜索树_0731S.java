package tree;

/***
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class _108_将有序数组转换为二叉搜索树_0731S {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if(left > right) return null;
		// 总是选择中间位置左边的数字作为根节点
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}
}
