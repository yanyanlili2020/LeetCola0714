package array;

/**
 * https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 */
public class _1413_逐步求和得到正数的最小值_0823S {
    class Solution {
        public int minStartValue(int[] nums) {
            int min = 0;
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                if(sum < min) {
                    min = sum;
                }
            }
            return 1 - min;
        }
    }
}
