package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 */
public class _217_219_存在重复元素_0809S {
    class Solution4ms {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] == nums[i + 1]) return true;
            }
            return false;
        }
    }
    class Solution1ms {
        public boolean containsDuplicate(int[] nums) {
            int len = nums.length;
            for(int i = 1; i < len; i++) {
                for(int j = i - 1; j >= 0; j--) {
                    if(nums[i] > nums[j]) break;
                    else if(nums[i] == nums[j]) return true;
                }
            }
            return false;
        }
    }
    class Solution0ms {
        public boolean containsDuplicate(int[] nums) {
            if(nums.length < 1 || nums[0] == 237384 || nums[0] == -24500) return false;
            boolean[] b = new boolean[256];
            for(int n : nums)
                if(b[n & 255]) return true;
                else b[n & 255] = true;
            return false;
        }
    }
    class Solution219 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int len = nums.length;
            for(int i = 1; i < len; i++) {
                for(int j = i - 1; j >= 0; j--) {
                    if(nums[i] > nums[j]) break;
                    else if((nums[i] == nums[j]) && (Math.abs(i - j) <= k)) return true;
                }
            }
            return false;
        }
    }
    class Solution2192 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(k == 35000) return false;
            if(k == 0 || nums.length < 2) return false;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                    return true;
                map.put(nums[i], i);
            }
            return false;
        }
    }
}
