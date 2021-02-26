package array;

/**
 * https://leetcode-cn.com/problems/transpose-matrix/
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 */
public class _867_转置矩阵_0813S {
    class Solution {
        public int[][] transpose(int[][] A) {
            int R = A.length, C = A[0].length;
            int[][] ans = new int[C][R];
            for(int r = 0; r < R; ++r)
                for(int c = 0; c < C; ++c) {
                    ans[c][r] = A[r][c];
                }
            return ans;
        }
    }
}
