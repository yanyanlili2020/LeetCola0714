package array;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class _643_子数组最大平均数 {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int maxSum = 0;
            int currentSum = 0;
            for (int i = 0; i < k; i++) {
                maxSum += nums[i];
            }
            currentSum = maxSum;
            for (int i = k; i < nums.length; i++) {
                currentSum = currentSum - nums[i-k] + nums[i];
                maxSum = maxSum < currentSum ? currentSum : maxSum;
            }
            return (double)maxSum / k;
        }
    }
}
