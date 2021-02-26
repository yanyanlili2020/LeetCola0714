package array;

/***
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
@SuppressWarnings("unused")
public class _1365_有多少小于当前数字的数字_0810S {
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            //buc为记录每个数字出现的次数，题的提示有0 <= nums[i] <= 100所以buc长度设为101
            int[] ans = new int[nums.length];
            int[] buc = new int[101];
            for(int i : nums) {
                buc[i]++;
            }
            //dp思想确认小于等于当前数字的个数
            for(int i = 1; i < buc.length; i++) {
                buc[i] += buc[i - 1];
            }
            //上一步是小于等于，根据题意可得小于当前数我们减一即可buc[nums[i]-1]，需注意如果当前数是0直接返回0即可
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) ans[i] = 0;
                else ans[i] = buc[nums[i] - 1];
            }
            return ans;
        }
    }
    class Solution慢 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] ans = new int[nums.length]; //用来存放统计个数
            int count = 0; //计数
            int t = 0;
            for(int i = 0; i < nums.length; i++) {
                count = 0; // 每次循环都要 归0
                for(int j = 0; j < nums.length; j++) {
                    if(nums[j] < nums[i] && j != i) {
                        count++;
                    }
                }
                ans[t++] = count; //t++ 用于每一位的统计的数位置
            }
            return ans;
        }
    }
}