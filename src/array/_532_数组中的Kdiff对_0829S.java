package array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j
 * 都是数组中的数字，且两数之差的绝对值是 k.
 */
public class _532_数组中的Kdiff对_0829S {
    class Solution {
        public int findPairs(int[] nums, int k) {
            //先排序后处理
            if(k < 0) return 0;
            Arrays.sort(nums);
            int start = 0, count = 0, prev = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] - nums[start] > k || prev == nums[start]) {
                    if (++start != i) i--;
                }else if (nums[i] - nums[start] == k) {
                    prev = nums[start++];
                    count++;
                }
            }
            return count;
        }
    }
}
