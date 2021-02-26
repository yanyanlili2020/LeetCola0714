package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class _697_数组的度_0814S {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> left = new HashMap(),
                    right = new HashMap(), count = new HashMap();
            for(int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if(left.get(x) == null) left.put(x, i);
                right.put(x, i);
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
            int ans = nums.length;
            int degree = Collections.max(count.values());
            for(int x : count.keySet()) {
                if(count.get(x) == degree) {
                    ans = Math.min(ans, right.get(x) - left.get(x) + 1);
                }
            }
            return ans;
        }
    }
}
