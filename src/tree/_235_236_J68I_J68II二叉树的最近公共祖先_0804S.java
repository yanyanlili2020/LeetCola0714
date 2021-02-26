package tree;

/***
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class _235_236_J68I_J68II二叉树的最近公共祖先_0804S {
	class _235_JOffer68I_BST {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			while(root != null) {
				if(p.val > root.val && q.val > root.val) root = root.right;
				if(p.val < root.val && q.val < root.val) root = root.left;
				else return root;
			}
			return null;
		}
	}
	class _236_JOffer68II {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if(root == null || root == p || root == q) return root;
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if(left == null) return right;
			if(right == null) return left;
			return root;
		}
	}
}
