package array;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/majority-element/
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * https://leetcode-cn.com/problems/find-majority-element-lcci/submissions/
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class _169_J39_m1710_多数元素_0810S {
    class Solution {
        // 因为求的众数的数量是大于一半的 所以排序后n/2的位置一定是众数
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
    class Solution2 {
        public int majorityElement(int[] nums) {
            int count = 1;
            int ans = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(ans == nums[i]) count++;
                else {
                    count--;
                    if(count == 0) {
                        ans = nums[i + 1];
                    }
                }
            }
            return ans;
        }
    }
}