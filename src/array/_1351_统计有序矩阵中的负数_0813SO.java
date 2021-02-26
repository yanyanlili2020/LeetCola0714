package array;

/**
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class _1351_统计有序矩阵中的负数_0813SO {
    class Solution {
        public int countNegatives(int[][] grid) {
            int cnt=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]<0){
                        cnt+= grid[i].length-j;
                        break;}
                    
                }
            }
            return cnt;
        }
    }
}
