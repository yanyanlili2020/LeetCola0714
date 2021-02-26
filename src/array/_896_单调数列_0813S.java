package array;

/**
 * https://leetcode-cn.com/problems/monotonic-array/
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */
public class _896_单调数列_0813S {
    class Solution {
        public boolean isMonotonic(int[] A) {
            return increasing(A) || decreasing(A);
        }
        public boolean increasing(int[] A) {
            for(int i = 0; i < A.length - 1; ++i)
                if(A[i] > A[i + 1]) return false;
            return true;
        }
        public boolean decreasing(int[] A) {
            for(int i = 0; i < A.length - 1; ++i)
                if(A[i] < A[i + 1]) return false;
            return true;
        }
    }
}
