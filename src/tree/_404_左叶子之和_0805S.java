package tree;

/***
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class _404_左叶子之和_0805S {
	class Solution {
		int ans = 0;
		public int sumOfLeftLeaves(TreeNode root) {
			if (root == null) { // 递归出口
				return 0;
			}
			// 根节点有左子节点，并且左子节点没有左右节点，说明左子节点是左叶子节点
			if (root.left != null && root.left.left == null && root.left.right == null) {
				ans += root.left.val;
			}
			sumOfLeftLeaves(root.left);
			sumOfLeftLeaves(root.right);
			return ans;
		}
		
	}
	class Solution2 {
		int sum=0;
		public int sumOfLeftLeaves(TreeNode root) {
			if(root==null) return sum;
			dfs(root);
			return sum;
		}
		private void dfs(TreeNode root){
			
			if(root==null) return;
			if(root.left!=null&&root.left.left==null&&root.left.right==null){
				sum+=root.left.val;
			}
			
			dfs(root.left);
			dfs(root.right);
		}
	}
	
	
}
