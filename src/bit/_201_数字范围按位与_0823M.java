package bit;

/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 0 & 0 = 0
 * 0 & 1 = 0
 * 1 & 0 = 0
 * 1 & 1 = 1
 */
public class _201_数字范围按位与_0823M {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            // 找到公共前缀
            while (m < n) {
                m >>= 1;
                n >>= 1;
                ++shift;
            }
            return m << shift;
        }
    }
    class Solution2 {
        public int rangeBitwiseAnd(int m, int n) {
            // 对比 342
            while(m < n) {
                // 抹去最右边的 1
                n = n & (n - 1);
            }
            return n;
        }
    }
}
