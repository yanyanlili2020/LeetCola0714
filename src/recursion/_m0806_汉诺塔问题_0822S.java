package recursion;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
@SuppressWarnings("unused")
public class _m0806_汉诺塔问题_0822S {
    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            //终止条件
            if(A.size() == 0)
                return;
            //取出栈顶
            Integer temp = A.remove(A.size() - 1);
            //递归下一层
            hanota(A, B, C);
            //将A中值存入C
            C.add(temp);
        }
    }
    class Solution2 {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            honoi(A.size(), A, B, C);
        }
        public void honoi(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
            if(n == 1) {
                C.add(A.get(A.size() - 1));
                A.remove(A.size() - 1);
            } else {
                //把A经过辅助C方法B上
                honoi(n - 1, A, C, B);
                //把A放到C上
                C.add(A.get(A.size() - 1));
                A.remove(A.size() - 1);
                //把B经过辅助放到C上
                honoi(n - 1, B, A, C);
            }
        }
    }
}
