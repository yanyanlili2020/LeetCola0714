package array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 给定一个整数数组，你需要寻找一个连续的子数组，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 */
public class _581_最短无序连续子数组_0814S {
    class Solution8ms {
        public int findUnsortedSubarray(int[] nums) {
            int[] snums = nums.clone();
            Arrays.sort(snums);
            int start = snums.length, end = 0;
            for(int i = 0; i < snums.length; i++) {
                if(snums[i] != nums[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return (end - start >= 0 ? end - start + 1 : 0);
        }
    }
    class Solution1ms {
        public int findUnsortedSubarray(int[] nums) {
            if(nums == null || nums.length < 1)
                return -1;
            int max = nums[0], min = nums[nums.length - 1];
            int left = 0, right = -1;//记录两个边界
            for(int i = nums.length - 1; i >= 0; i--) {//从右开始
                if(nums[i] <= min) {
                    min = nums[i];
                } else {
                    left = i;
                }
            }
            for(int i = 0; i < nums.length; i++) {//从左开始
                if(nums[i] >= max) {
                    max = nums[i];
                } else {
                    right = i;
                }
            }
            return right - left + 1;
        }
    }
}
