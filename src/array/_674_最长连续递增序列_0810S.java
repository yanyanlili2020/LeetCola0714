package array;

/***
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 */
public class _674_最长连续递增序列_0810S {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int ans = 0, next = 0;
            for(int i = 0; i < nums.length; ++i) {
                if(i > 0 && nums[i - 1] >= nums[i]) {
                    next = i;
                }
                ans = Math.max(ans, i - next + 1);
            }
            return ans;
        }
    }
    class Solution1ms {
        public int findLengthOfLCIS(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int temp = nums[0];
            int out = 1, tempOut = 1;
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > temp) {
                    tempOut++;
                } else {
                    tempOut = 1;
                }
                temp = nums[i];
                if(tempOut > out) {
                    out = tempOut;
                }
            }
            return out;
        }
    }
}
