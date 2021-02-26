package math;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 * <p>
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 */
public class _908_910_最小差值_0825SM {
    class _908 {
        class Solution3 {
            public int smallestRangeI(int[] A, int K) {
                if(A.length == 1) {
                    return 0;
                }
                int min = A[0];
                int max = A[0];
                for(int n : A) {
                    min = Math.min(min, n);
                    max = Math.max(max, n);
                }
                return Math.max(0, max - min - 2 * K);
            }
        }
        class Solution1 {
            public int smallestRangeI(int[] A, int K) {
                if(A.length == 1) {
                    return 0;
                }
                int max = -1;
                int min = 10001;
                for(int i = 0; i < A.length; i++) {
                    if(A[i] > max) {
                        max = A[i];
                    }
                    if(A[i] < min) {
                        min = A[i];
                    }
                }
                if(max - min >= 2 * K) {
                    return max - min - 2 * K;
                }
                else return 0;
            }
        }
    }
    class _910{
        class Solution11 {
            public int smallestRangeII(int[] A, int K) {
                Arrays.sort(A);
                int n = A.length;
                int res = A[n-1] - A[0];
                for (int i=1;i<n;i++) {
                    int min = Math.min(A[0]+K,A[i]-K);
                    int max = Math.max(A[n-1]-K,A[i-1]+K);
                    res = Math.min(max-min,res);
                }
                return res;
            }
        }
        class Solution9 {
            public int smallestRangeII(int[] A, int K) {
                Arrays.sort(A);
                int max = A[A.length - 1];
                int ans = max - A[0];
                int min = A[0] + 2*K;
                for(int i = 0; i < A.length - 1; i++) {
                    if(A[i] + 2*K < max) {
                        ans = Math.min(ans, max - Math.min(A[i+1], A[0]+2*K));
                        continue;
                    }
                    if(max - A[i] > A[i] + 2*K - A[i+1]) {
                        ans = Math.min(ans, A[i] + 2*K -Math.min(A[i+1], min));
                    }
                    max = A[i] + 2*K;
                }
            
                return ans;
            }
        }
    }
}
