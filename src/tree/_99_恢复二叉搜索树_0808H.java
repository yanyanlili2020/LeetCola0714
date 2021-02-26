package tree;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused")
public class _99_恢复二叉搜索树_0808H {
    static class Solution {
        // 快
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        
        public void recoverTree(TreeNode root) {
            in_order(root);
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
        
        private void in_order(TreeNode root){
            if(root == null){
                return;
            }
            in_order(root.left);
            if(firstNode == null && preNode.val > root.val){
                firstNode = preNode;
            }
            if(firstNode != null && preNode.val > root.val){
                secondNode = root;
            }
            preNode = root;
            in_order(root.right);
        }
    }
    static class Solution2 {
        // 官方
        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);
            int[] swapped = findTwoSwapped(nums);
            recover(root, 2, swapped[0], swapped[1]);
        }
        
        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }
        
        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int x = -1, y = -1;
            for (int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    y = nums.get(i + 1);
                    if (x == -1) {
                        x = nums.get(i);
                    } else {
                        break;
                    }
                }
            }
            return new int[]{x, y};
        }
        
        public void recover(TreeNode root, int count, int x, int y) {
            if (root != null) {
                if (root.val == x || root.val == y) {
                    root.val = root.val == x ? y : x;
                    if (--count == 0) {
                        return;
                    }
                }
                recover(root.right, count, x, y);
                recover(root.left, count, x, y);
            }
        }
    }
    
    
}
