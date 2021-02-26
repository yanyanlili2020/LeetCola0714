package array;

import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class _J03_数组中重复的数字_0811S {
    class Solution3 {
        public int findRepeatNumber(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] == nums[i + 1]) return nums[i];
            }
            return -1;
        }
    }
    class Solution1 {
        public int findRepeatNumber(int[] nums) {
            int tmp;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == i) continue;
                else {
                    if(nums[i] == nums[nums[i]]) return nums[i];
                    tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
            return 0;
        }
    }
}
