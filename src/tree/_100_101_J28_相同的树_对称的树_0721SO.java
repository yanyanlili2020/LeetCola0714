package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
/***
 * https://leetcode-cn.com/problems/same-tree/
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */

/***
 * https://leetcode-cn.com/problems/symmetric-tree/
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/submissions/
 * 给定两个二叉树,判断是否对称
 */
public class _100_101_J28_相同的树_对称的树_0721SO {
    class _100 {
        /*	首先判断 p 和 q 是不是 None，然后判断它们的值是否相等。
            若以上判断通过，则递归对子结点做同样操作。*/
        class Solution1 {
            public boolean isSameTree(TreeNode p, TreeNode q) {
                if(p == null && q == null) return true;// 空树不用
                if(q == null || p == null) return false;// 根节点不同 false
                if(p.val != q.val) return false;
                return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
            }
        }
        /**
         * 从根开始，每次迭代将当前结点从双向队列中弹出。
         * 然后，进行方法equal的判断: p q 是否相等：
         * p 和 q 不是 None,
         * p.val 等于 q.val,
         * 若以上均满足，则压入子结点。
         */
        class Solution2 {
            // p q 相等或都为空 返回true p q其一为空或值不同 返回false
            public boolean equal(TreeNode p, TreeNode q) {
                if(p == null && q == null) return true;
                if(q == null || p == null) return false;
                if(p.val != q.val) return false;
                return true;//  p q 值相等
            }
            public boolean isSameTree(TreeNode p, TreeNode q) {
                if(p == null && q == null) return true;// p q都为空 则为相等的树
                if(!equal(p, q)) return false;// 如果 p q 不等 返回false 结束
                ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();// 建立两个装树节点的双端队列
                ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
                deqP.addLast(p);
                deqQ.addLast(q);
                while(!deqP.isEmpty()) {
                    p = deqP.removeFirst();
                    q = deqQ.removeFirst();
                    if(!equal(p, q)) return false;
                    if(p != null) {
                        if(!equal(p.left, q.left)) return false;
                        if(p.left != null) {
                            deqP.addLast(p.left);
                            deqQ.addLast(q.left);
                        }
                        if(!equal(p.right, q.right)) return false;
                        if(p.right != null) {
                            deqP.addLast(p.right);
                            deqQ.addLast(q.right);
                        }
                    }
                }
                return true;
            }
        }
        class Solution3 {
            public boolean isSameTree(TreeNode p, TreeNode q) {
                Queue<TreeNode> ans = new LinkedList<TreeNode>();// 建立一个链表
                ans.offer(p);// 将指定元素添加到此链表的末尾
                ans.offer(q);
                while(!ans.isEmpty()) {
                    p = ans.poll();// 获取并移除此列表的头
                    q = ans.poll();
                    if(p == null && q == null) continue;
                    if((p == null || q == null) || (p.val != q.val)) return false;
                    ans.offer(p.left);
                    ans.offer(q.left);
                    ans.offer(p.right);
                    ans.offer(q.right);
                }
                return true;
            }
        }
    }
    class _101_JOffer28 {
        class Solution1 {
            // 递归
            public boolean isSymmetric(TreeNode root) {
                return equal(root, root);
            }
            public boolean equal(TreeNode p, TreeNode q) {
                if(p == null && q == null) return true;
                if(p == null || q == null) return false;
                return p.val == q.val && equal(p.left, q.right) && equal(p.right, q.left);
            }
        }

        class Solution2 {
            // 迭代 分别装入p的left q的right 进行对比
            public boolean isSymmetric(TreeNode root) {
                return symmetry(root, root);
            }

            public boolean symmetry(TreeNode p, TreeNode q) {
                Queue<TreeNode> ans = new LinkedList<TreeNode>();// 建立一个链表
                ans.offer(p);// 将指定元素添加到此链表的末尾
                ans.offer(q);
                while(!ans.isEmpty()) {
                    p = ans.poll();// 获取并移除此列表的头
                    q = ans.poll();
                    if(p == null && q == null) continue;
                    if((p == null || q == null) || (p.val != q.val)) return false;
                    ans.offer(p.left);
                    ans.offer(q.right);
                    ans.offer(p.right);
                    ans.offer(q.left);
                }
                return true;
            }
        }
    }
}
