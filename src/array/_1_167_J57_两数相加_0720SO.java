package array;

import java.util.HashMap;
import java.util.Map;
/***
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
/***
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 给定一个已按照 升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 *     返回的下标值（index1 和 index2）不是从零开始的。
 *     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
// 注意已知数组是否排好序
public class _1_167_J57_两数相加_0720SO {
    class Solution1 {
        // 1 ms 特殊思路
        public int[] twoSum(int[] nums, int target) {
            int max = 2047;// java中，2047是正整数，对应原码和补码一样，都是11111111111
            int diff = 0;
            int[] ans = new int[max + 1];// 开了个大小为2048的数组
            for(int i = 0; i < nums.length; i++) {
                diff = target - nums[i];
                if(ans[diff & max] != 0) {
// ans[diff & max] 差是正数，那么结果=差
//                 差是0，那么结果还是0（因为用的是补码，不像反码那样区分正负0）
//                 差是负数，那么结果是会被转化为0-2047之间的正数，存放到相应的位置，负值越大，越接近2047，反之越接近0。
                    return new int[]{ans[diff & max] - 1, i};
                }
                else {
                    ans[nums[i] & max] = i + 1;
                }
            }
            return null;
        }
    }
    class Solution3 {
        // 3 ms
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if(map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
            // return null; // 抛异常快2ms
        }
        class Solution {
            // 暴力 慢
            public int[] twoSum(int[] nums, int target) {
                for(int i = 0; i < nums.length; i++) {
                    for(int j = i + 1; j < nums.length; j++) {
                        if(nums[j] == target - nums[i]) {
                            return new int[]{i, j};
                        }
                    }
                }
                throw new IllegalArgumentException("No two sum solution");
            }
        }
    }
    class _167_0720S_两数之和II输入有序数组_J57_和为s的两个数字_0902S {
        // 必须有序 167返回下标 J57 返回对应值
        class Solution {
            public int[] twoSum(int[] numbers, int target) {
                int slow = 0;
                int fast = numbers.length - 1;
                while(slow < fast) {
                    int sum = numbers[slow] + numbers[fast];
                    if(sum == target) {
                        return new int[]{slow + 1, fast + 1};
                        // return new int[]{nums[slow], nums[fast]}; J57 返回对应值
                    }
                    else if(sum < target) {
                        ++slow;
                    }
                    else --fast;
                }
                return new int[]{-1, -1};
            }
        }
    }
}
