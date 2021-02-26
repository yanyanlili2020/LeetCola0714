package math;

/***
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * https://leetcode-cn.com/problems/factorial-zeros-lcci/
 */
public class _172_m1605_阶乘后的零_0812S {
    class Solution {
        public int trailingZeroes(int n) {
            int zeroCount = 0;
            long currentMultiple = 5;
            while(n > 0) {
                n /= 5;
                zeroCount += n;
            }
            return zeroCount;
        }
    }
}
