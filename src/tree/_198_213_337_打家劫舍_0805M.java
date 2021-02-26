package tree;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/house-robber/
 * https://leetcode-cn.com/problems/house-robber-ii/
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class _198_213_337_打家劫舍_0805M {
	class _198数组 {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}
			int length = nums.length;
			if (length == 1) {
				return nums[0];
			}
			int first = nums[0], second = Math.max(nums[0], nums[1]);
			for (int i = 2; i < length; i++) {
				int temp = second;
				second = Math.max(first + nums[i], second);
				first = temp;
			}
			return second;
		}
	}
	
	class _213环形 {
		public int rob(int[] nums) {
			if(nums.length == 0) return 0;
			if(nums.length == 1) return nums[0];
			return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
					myRob(Arrays.copyOfRange(nums, 1, nums.length)));
		}
		private int myRob(int[] nums) {
			int pre = 0, cur = 0, tmp;
			for(int num : nums) {
				tmp = cur;
				cur = Math.max(pre + num, cur);
				pre = tmp;
			}
			return cur;
		}
	}
	class _337二叉树 {
		public int rob(TreeNode root) {
			int[] rootStatus = dfs(root);
			return Math.max(rootStatus[0], rootStatus[1]);
		}
		
		public int[] dfs(TreeNode node) {
			if (node == null) {
				return new int[]{0, 0};
			}
			int[] l = dfs(node.left);
			int[] r = dfs(node.right);
			int selected = node.val + l[1] + r[1];
			int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
			return new int[]{selected, notSelected};
		}
	}
}
