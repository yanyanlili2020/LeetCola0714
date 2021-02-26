package array;

/**
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 */
public class _1295_统计位数为偶数的数字_0810S {
    class Solution {
        public int findNumbers(int[] nums) {
            int count=0;
            for(int n:nums){
                if((n>=10&&n<=99)||(n>=1000&&n<=9999)||n==100000)
                    count++;
            }
            return count;
        }
    }
}
