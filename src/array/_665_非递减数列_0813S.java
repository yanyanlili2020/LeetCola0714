package array;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class _665_非递减数列_0813S {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;
            for(int i = 1; i < nums.length && cnt <= 1; i++) {
                if(nums[i - 1] > nums[i]) {
                    cnt++;
                    if(i - 2 >= 0 && nums[i - 2] > nums[i]) {
                        nums[i] = nums[i - 1];
                    }
                }
            }
            return cnt <= 1;
        }
    }
}
