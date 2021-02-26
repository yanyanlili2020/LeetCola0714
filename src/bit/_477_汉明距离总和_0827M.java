package bit;

/**
 * https://leetcode-cn.com/problems/total-hamming-distance/
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 */
public class _477_汉明距离总和_0827M {
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int len = nums.length;
            int ans = 0;
            for(int i = 0; i < 32; i++) {
                int one = 0;
                for(int j = 0; j < len; j++) {
                    one += (nums[j] & 1); //  one += (nums[j] >>> i) & 1; 两句合并
                    nums[j] >>= 1;
                }
                ans += one * (len - one);
            }
            return ans;
        }
    }
}
