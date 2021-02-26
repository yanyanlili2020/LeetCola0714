package tree;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 */

public class _m0402_最小高度树_0721S {
	class Solution1 {// 1ms
		//		sortedArrayToBST方法是传入一个数组，
//		然后取数组中间的数建立根节点root，然后以中间为分界，
//		将左边的子数组和右边的子数组分别传入sortedArrayToBST进行递归，
//		返回的是左子树和右子树的根节点，令其等于root.left和root.right即可：
		public TreeNode sortedArrayToBST(int[] nums) {
			if(nums.length == 0) return null;
			TreeNode node = new TreeNode(nums[nums.length / 2]);
			node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
			node.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
			return node;
		}
	}

	class Solution2 {// 0ms
		public TreeNode sortedArrayToBST(int[] nums) {
			return helper(nums, 0, nums.length);
		}
		public TreeNode helper(int[] nums, int left, int right) {
			if(left == right) return null;
			int mid = (left + right) >> 1;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = helper(nums, left, mid);
			node.right = helper(nums, mid + 1, right);
			return node;
		}
	}
}
