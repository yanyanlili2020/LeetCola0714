package array;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/submissions/
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 */
public class _1480_一维数组的动态和_0813S {
    class Solution {
        public int[] runningSum(int[] nums) {
        // 先计算length可以省一点点内存
            for(int i = 1, len = nums.length; i < len; i++) {
                nums[i] = nums[i] + nums[i - 1];
            }
            return nums;
        }
    }
}
