package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 给定一个二叉树和一个目标和，
 * 判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和
 */
public class _112_路径综合_0903S {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) {
                return false;
            }
            if(root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
    class Solution2 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) {
                return false;
            }
            Queue<TreeNode> queNode = new LinkedList<TreeNode>();
            Queue<Integer> queVal = new LinkedList<Integer>();
            queNode.offer(root);
            queVal.offer(root.val);
            while(!queNode.isEmpty()) {
                TreeNode now = queNode.poll();
                int temp = queVal.poll();
                if(now.left == null && now.right == null) {
                    if(temp == sum) {
                        return true;
                    }
                    continue;
                }
                if(now.left != null) {
                    queNode.offer(now.left);
                    queVal.offer(now.left.val + temp);
                }
                if(now.right != null) {
                    queNode.offer(now.right);
                    queVal.offer(now.right.val + temp);
                }
            }
            return false;
        }
    }
}
