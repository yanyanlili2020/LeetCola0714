package tree;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class _872_叶子相似的树_0802S {
	class Solution1 {
		public boolean leafSimilar(TreeNode root1, TreeNode root2) {
			List<Integer> leaves1 = new ArrayList();
			List<Integer> leaves2 = new ArrayList();
			dfs(root1, leaves1);
			dfs(root2, leaves2);
			return leaves1.equals(leaves2);
		}
		
		public void dfs(TreeNode node, List<Integer> leafValues) {
			if(node != null) {
				if(node.left == null && node.right == null)
					leafValues.add(node.val);
				dfs(node.left, leafValues);
				dfs(node.right, leafValues);
			}
		}
	}
	
	class Solution2 {
		/**
		 * 要叶子从左到右的顺序一致
		 *
		 */
		public boolean leafSimilar(TreeNode root1, TreeNode root2) {
			return helper(root1, 0) == helper(root2, 0);
		}
		
		public int helper(TreeNode node, int result) {
			if(node == null) return result;
			if(node.left == null && node.right == null) {
				return result * 10 + node.val;
			}
			return helper(node.right, helper(node.left, result));
		}
	}
}
