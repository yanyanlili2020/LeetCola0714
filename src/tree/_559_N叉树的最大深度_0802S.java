package tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度_0802S {
	//递归
	class Solution1 {
		public int maxDepth(Node root) {
			if(root == null) return 0;
			int max = 0;
			for(Node subNode : root.children) {
				int depth = maxDepth(subNode);
				max = Math.max(max, depth);
			}
			return max + 1;
		}
	}
	
	//迭代 层序遍历
	class Solution2 {
		public int maxDepth2(Node root) {
			if(root == null) return 0;
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			int maxDepth = 0;
			while(!queue.isEmpty()) {
				int count = queue.size();
				maxDepth++;
				while(count > 0) {
					count--;
					Node cur = queue.poll();
					for(Node node : cur.children) {
						if(node != null)
							queue.add(node);
					}
				}
			}
			return maxDepth;
		}
	}
}
