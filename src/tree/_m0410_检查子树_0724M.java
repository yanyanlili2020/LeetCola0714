package tree;

/***
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 */
public class _m0410_检查子树_0724M {
	public boolean checkSubTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(helper(t1, t2)) return true;
		else return checkSubTree(t1.right, t2) || checkSubTree(t1.left, t2);
	}
	public boolean helper(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 != null && t2 != null) {
			if(t1.val == t2.val)
				return helper(t1.left, t2.left) && helper(t1.right, t2.right);
			return false;
		}
		return false;
	}
}
