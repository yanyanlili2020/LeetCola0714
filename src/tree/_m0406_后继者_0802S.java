package tree;

/***
 * https://leetcode-cn.com/problems/successor-lcci/
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 */
public class _m0406_后继者_0802S {
	class Solution {
		public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
			TreeNode ans = root;
			TreeNode curr = root;
			while (curr != null){
				//如果当前节点的值小于等于目标节点的值，那一定不是答案节点，且答案节点在该节点的右孩子中
				if (curr.val <= p.val) {
					curr = curr.right;
				} else {
					//如果当前节点的值大于目标节点的值，那么该节点有可能是答案节点，
					// 具体是不是需要遍历其左孩子，寻找更靠近p节点值的答案
					ans = curr;
					curr = curr.left;
				}
			}
			return ans.val <= p.val ? null : ans;
		}
	}
}
	
		
		
		

