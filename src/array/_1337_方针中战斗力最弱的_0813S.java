package array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class _1337_方针中战斗力最弱的_0813S {
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int[] list = new int[mat.length];
            int[] result = new int[k];
            for(int i = 0; i < mat.length; i++) {
                list[i] = count(mat[i]) * 100 + i;
            }
            Arrays.sort(list);
            for(int i = 0; i < k; i++) {
                result[i] = list[i] % 100;
            }
            return result;
        }
        public int count(int[] nums) {// 计算有多少个1
            int sum = 0;
            for(int n : nums) {
                if(n != 1) {
                    break;
                }// 1都在0前面
                sum += n;
            }
            return sum;
        }
    }
}
