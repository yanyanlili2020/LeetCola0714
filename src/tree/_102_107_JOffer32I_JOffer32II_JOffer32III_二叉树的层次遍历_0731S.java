package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * 给定一个二叉树，返回其节点值 自底向上 的层次遍历。
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 从上到下打印出二叉树的每个节点。
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 请实现一个函数按照之字形顺序打印二叉树，即奇数行按照从左到右的顺序打印，偶数行按照从右到左的顺序打印.
 */
public class _102_107_JOffer32I_JOffer32II_JOffer32III_二叉树的层次遍历_0731S {
    public class _102_层序遍历_JOffer32II {
        //递归
        class Solution1 {
            /**
             * 层序遍历 将二叉树的每一层存入list 再将每一个list作为元素存入新的list
             * 直接调用 helper 方法
             */
            public List<List<Integer>> levelOrder(TreeNode root) {
                return helper(root, null, 0);
            }
            public List<List<Integer>> helper(TreeNode root, List<List<Integer>> list, int level) {
                if(list == null) list = new ArrayList<>();
                if(root == null) return list;
                if(list.size() == level) {
                    list.add(new ArrayList<>());
                }
                list.get(level).add(root.val);
                helper(root.left, list, level + 1);
                helper(root.right, list, level + 1);
                return list;
            }
        }
        class Solution2 {
            /**
             * 将根节点放入队列中，然后不断遍历队列
             * 获取当前队列的长度，这个长度相当于 当前这一层的节点个数
             * 将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
             * 如果节点的左/右子树不为空，也放入队列中
             * 将临时list加入最终返回结果中
             */
            public List<List<Integer>> levelOrder(TreeNode root) {
                if(root == null) return new ArrayList<List<Integer>>();
                List<List<Integer>> ans = new ArrayList<List<Integer>>();
                LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
                queue.add(root);
                while(queue.size() > 0) {
                    int size = queue.size();
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    for(int i = 0; i < size; ++i) {
                        TreeNode t = queue.remove();
                        tmp.add(t.val);
                        if(t.left != null) queue.add(t.left);
                        if(t.right != null) queue.add(t.right);
                    }
                    ans.add(tmp);
                }
                return ans;
            }
        }
    }
    public class _107_二叉树的层次遍历II {
        //递归 倒序按层输出二叉树
        class Solution1 {
            List<List<Integer>> result = new ArrayList<>();
            public List<List<Integer>> levelOrderBottom(TreeNode root) {
                helper(root, 0);
                return result;
            }
            private void helper(TreeNode root, int level) {
                if(root == null) return;
                if(result.size() < level + 1) result.add(0, new ArrayList<>());
                int bucket = result.size() - level - 1;
                result.get(bucket).add(root.val);
                helper(root.left, level + 1);
                helper(root.right, level + 1);
            }
        }
        class Solution2 {
            public List<List<Integer>> levelOrderBottom(TreeNode root) {
                TreeNode p = root;//循环指针
                List<List<Integer>> result = new LinkedList<>();//要返回的结果列表
                Queue<TreeNode> myQueue = new LinkedList<TreeNode>();//辅助队列
                if(p == null) return result;//如果树为空就返回空表
                myQueue.offer(p);//将根节点入队
                while(!myQueue.isEmpty()) {//循环跳出条件为队空
                    List<Integer> tempList = new ArrayList<>();//创建临时列表
                    int len = myQueue.size();//记录下此时队列的长度
                    for(int i = 0; i < len; i++) {//进行len次循环，刚好将本层元素的值全部出队并送入临时列表
                        p = myQueue.poll();//将队顶元素出队
                        tempList.add(p.val);//将队顶元素的值送入临时列表
                        if(p.left != null) myQueue.offer(p.left);//队顶元素左子节点入队
                        if(p.right != null) myQueue.offer(p.right);//队顶元素右子节点入队
                    }
                    result.add(0, tempList);
                }
                return result;
            }
        }
    }
    public class _JOffer32I {
        // 用数组输出二叉树
        public int[] levelOrder(TreeNode root) {
            if(root == null) return new int[0];
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
            ArrayList<Integer> ans = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            int[] res = new int[ans.size()];
            for(int i = 0; i < ans.size(); i++)
                res[i] = ans.get(i);
            return res;
        }
    }
    public class _JOffer32III {
        // 奇数层正序 偶数层逆序
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if(root != null) queue.add(root);
            while(!queue.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for(int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                    else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
