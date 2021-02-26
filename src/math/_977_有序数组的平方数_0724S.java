package math;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class _977_有序数组的平方数_0724S {
    class Solution1 {
        // 遍历数组 给每项平方 排序 输出
        public int[] sortedSquares(int[] A) {
            for(int i = 0; i < A.length; i++) {
                A[i] = A[i] * A[i];
            }
            Arrays.sort(A);
            return A;
        }
    }
    class Solution2 {
        public int[] sortedSquares(int[] A) {
            int left = 0;
            int right = A.length - 1;
            int n = right;
            int[] ans = new int[right + 1];
            while(n >= 0) {
                if(Math.abs(A[left]) > Math.abs(A[right])) {
                    ans[n] = A[left] * A[left];
                    left++;
                } else {
                    ans[n] = A[right] * A[right];
                    right--;
                }
                n--;
            }
            return ans;
        }
    }
    class Solution3 {
        // 快 使用两个指针分别读取数组的非负部分与负数部分
        // 指针 i 反向读取负数部分，指针 j 正向读取非负数部分。
        public int[] sortedSquares2(int[] A) {
            int j = 0;
            while(j < A.length && A[j] < 0)
                j++;
            int i = j - 1;
            int[] ans = new int[A.length];
            int t = 0;
            while(i >= 0 && j < A.length) {
                if(A[i] * A[i] < A[j] * A[j]) {
                    ans[t++] = A[i] * A[i];
                    i--;
                } else {
                    ans[t++] = A[j] * A[j];
                    j++;
                }
            }
            while(i >= 0) {
                ans[t++] = A[i] * A[i];
                i--;
            }
            while(j < A.length) {
                ans[t++] = A[j] * A[j];
                j++;
            }
            return ans;
        }
    }
}
