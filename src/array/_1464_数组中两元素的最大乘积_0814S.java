package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 */
public class _1464_数组中两元素的最大乘积_0814S {
    class Solution0ms {
        // 因为数是大于0 的 要乘积最大 就是要乘数最大
        public int maxProduct(int[] nums) {
            int max1 = 0;
            int max2 = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] > max1) {
                    max2 = max1;
                    max1 = nums[i];
                } else if(nums[i] > max2)
                    max2 = nums[i];
            }
            return (max1 - 1) * (max2 - 1);
        }
        class Solution65ms {
            // 自己写的 巨慢
            public int maxProduct(int[] nums) {
                // int[]max=int[501];
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < nums.length; ++i) {
                    for(int j = i + 1; j < nums.length; ++j) {
                        list.add((nums[i] - 1) * (nums[j] - 1));
                    }
                }
                int max = 0;
                for(Integer n : list)
                    max = Math.max((int) n, max);
                return max;
            }
        }
    }
}
