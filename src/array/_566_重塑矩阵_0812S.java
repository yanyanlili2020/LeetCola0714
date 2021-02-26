package array;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 * 将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 */
public class _566_重塑矩阵_0812S {
    public class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int[][] res = new int[r][c];
            // 检查矩阵是否为空 新旧矩阵是否含同数量元素
            if(nums.length == 0 || r * c != nums.length * nums[0].length)
                return nums;
            int rows = 0, cols = 0;
            for(int i = 0; i < nums.length; i++) {
                for(int j = 0; j < nums[0].length; j++) {
                    res[rows][cols] = nums[i][j];
                    cols++;
                    if(cols == c) {
                        rows++;
                        cols = 0;
                    }
                }
            }
            return res;
        }
    }
}
