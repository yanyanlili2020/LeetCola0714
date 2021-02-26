package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 给定一个二叉树，返回它的 三种 遍历。
 */
@SuppressWarnings("unused")
public class _94_144_145_二叉树的前中后序遍历_0720M {
    public class _144_前序遍历 {
        /**
         * 递归
         */
        class Solution1 {
            public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> ans = new ArrayList<>();
                preorder(ans, root);
                return ans;
            }
            public void preorder(List<Integer> ans, TreeNode root) {
                if(root != null) {
                    ans.add(root.val);
                    if(root.left != null) {
                        preorder(ans, root.left);
                    }
                    if(root.right != null) {
                        preorder(ans, root.right);
                    }
                }
            }
        }
        /**
         * 迭代
         */
        class Solution2 {
            /*用两个链表,一个存节点,一个存结果.
            从根节点开始，每次迭代弹出当前栈顶元素，
            并将其孩子节点压入栈中，先压右孩子再压左孩子。
            在这个算法中，输出到最终结果的顺序按照
            Top->Bottom 和 Left->Right，符合前序遍历的顺序。*/
            public List<Integer> preorderTraversal(TreeNode root) {
                LinkedList<TreeNode> stack = new LinkedList<>();
                LinkedList<Integer> ans = new LinkedList<>();
                if(root == null) return ans;
                stack.add(root);
                while(!stack.isEmpty()) {
                    TreeNode node = stack.pollLast();
                    ans.add(node.val);
                    if(node.right != null) {
                        stack.add(node.right);
                    }
                    if(node.left != null) {
                        stack.add(node.left);
                    }
                }
                return ans;
            }
        }

        // 莫里斯遍历 ?
        class Solution3 {
            /*算法的思路是从当前节点向下访问先序遍历的前驱节点，每个前驱节点都恰好被访问两次。
            首先从当前节点开始，向左孩子走一步然后沿着右孩子一直向下访问，
            直到到达一个叶子节点（当前节点的中序遍历前驱节点），
            所以我们更新输出并建立一条伪边 predecessor.right = root 更新这个前驱的下一个点。
            如果我们第二次访问到前驱节点，由于已经指向了当前节点，我们移除伪边并移动到下一个顶点。
            如果第一步向左的移动不存在，就直接更新输出并向右移动。
            */
            public List<Integer> preorderTraversal(TreeNode root) {
                LinkedList<Integer> ans = new LinkedList<>();
                TreeNode node = root;
                while(node != null) {
                    if(node.left == null) {
                        ans.add(node.val);
                        node = node.right;
                    } else {
                        TreeNode predecessor = node.left;
                        while((predecessor.right != null) && (predecessor.right != node)) {
                            predecessor = predecessor.right;
                        }
                        if(predecessor.right == null) {
                            ans.add(node.val);
                            predecessor.right = node;
                            node = node.left;
                        } else {
                            predecessor.right = null;
                            node = node.right;
                        }
                    }
                }
                return ans;
            }
        }
    }

    public class _94_中序 {
        /**
         * 递归
         */
        class Solution1 {
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> ans = new ArrayList<>();
                inorder(ans, root);
                return ans;
            }
            public void inorder(List<Integer> ans, TreeNode root) {
                if(root != null) {
                    if(root.left != null) {
                        inorder(ans, root.left);
                    }
                    ans.add(root.val);
                    if(root.right != null) {
                        inorder(ans, root.right);
                    }
                }
            }
        }
            /**
             * 迭代
             */
        class Solution2 {
            public List<Integer> inorderTraversal(TreeNode root) {
                LinkedList<TreeNode> stack = new LinkedList<>();
                LinkedList<Integer> ans = new LinkedList<>();
                if(root == null) return ans;
                stack.add(root);
                while(!stack.isEmpty()) {
                    TreeNode node = stack.pollLast();
                    ans.addFirst(node.val);
                    if(node.left != null) {
                        stack.add(node.left);
                    }
                    if(node.right != null) {
                        stack.add(node.right);
                    }
                }
                return ans;
            }
        }
        // 莫里斯中序遍历
        class Solution3 {
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> ldr = new ArrayList<Integer>();
                TreeNode cur = root;
                TreeNode pre = null;
                while(cur != null) {
                    if(cur.left == null) {//左子树为空，输出当前节点，将其右孩子作为当前节点
                        ldr.add(cur.val);
                        cur = cur.right;
                    } else {
                        pre = cur.left;//左子树
                        while(pre.right != null && pre.right != cur) {//找到前驱节点，即左子树中的最右节点
                            pre = pre.right;
                        }
                        //如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
                        if(pre.right == null) {
                            pre.right = cur;
                            cur = cur.left;
                        }
                        //如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
                        if(pre.right == cur) {
                            pre.right = null;
                            ldr.add(cur.val);
                            cur = cur.right;
                        }
                    }
                }
                return ldr;
            }
        }
    }

    public class _145_后序 {
        /**
         * 递归
         */
        class Solution1 {
            public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> ans = new ArrayList<>();
                if(root == null) return ans;
                postorder(ans, root);
                return ans;
            }
            public void postorder(List<Integer> ans, TreeNode root) {
                if(root.left != null) postorder(ans, root.left);
                if(root.right != null) postorder(ans, root.right);
                ans.add(root.val);
            }
        }

        /**
         * 迭代
         */
        class Solution2 {
            public List<Integer> postorderTraversal(TreeNode root) {
                LinkedList<TreeNode> stack = new LinkedList<>();
                LinkedList<Integer> ans = new LinkedList<>();
                if(root == null) return ans;
                stack.add(root);
                while(!stack.isEmpty()) {
                    TreeNode node = stack.pollLast();
                    ans.addFirst(node.val);
                    if(node.left != null) {
                        stack.add(node.left);
                    }
                    if(node.right != null) {
                        stack.add(node.right);
                    }
                }
                return ans;
            }
        }
    }
}
