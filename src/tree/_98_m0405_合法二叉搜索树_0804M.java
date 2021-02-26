package tree;

/***
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 */
public class _98_m0405_合法二叉搜索树_0804M {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            TreeNode maxLeft = root.left, minRight = root.right;
            // 找寻左子树中的最右（数值最大）节点
            while (maxLeft != null && maxLeft.right != null) maxLeft = maxLeft.right;
            // 找寻右子树中的最左（数值最小）节点
            while (minRight != null && minRight.left != null) minRight = minRight.left;
            // 当前层是否合法
            boolean ans = (maxLeft == null || maxLeft.val < root.val) && (minRight == null || root.val < minRight.val);
            // 进入左子树和右子树并判断是否合法
            return  ans && isValidBST(root.left) && isValidBST(root.right);
        }
    }
}
