package array;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/ 5500
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 */
public class _1567_乘积为正数的最长子数组长度_0830M {
    class Solution {
        public int getMaxLen(int[] nums) {
            int ret = 0;
            int totf = 0;
            int wz1 = -1, wz2 = -2;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    totf = 0;
                    wz1 = i;
                    wz2 = -2;
                }
                else {
                    if(nums[i] < 0) totf++;
                    if(totf % 2 == 0) {
                        if(wz1 == -2) wz1 = i;
                        else ret = Math.max(ret, i - wz1);
                    }
                    else {
                        if(wz2 == -2) wz2 = i;
                        else ret = Math.max(ret, i - wz2);
                    }
                }
            }
            return ret;
        }
    }
}
