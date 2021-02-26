package hash;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 */
public class _594_最长和谐子序列_0830S{
    class Solution5 {
        public int findLHS(int[] nums) {
            if (nums.length<2)return 0;
            int min = nums[0];
            int max = nums[0];
            for (int num : nums) {
                if (num>max)max = num;
                if (num<min)min = num;
            }
            int len = max - min + 1;
            int result = 0;
            if (len<nums.length*10) {//计数可能超出内存限制
                int[] map = new int[len];
                for (int num : nums) {
                    map[num-min]++;
                }
                for (int i = 1; i < len; i++) {
                    if (map[i]!=0 && map[i-1]!=0 && map[i]+map[i-1] > result)result = map[i-1] + map[i];
                }
            }else {
                Arrays.sort(nums);
                int per = nums[0];int cur = nums[0];int m = 1;int pm = 0;
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] == cur){
                        m++;
                    }else {
                        if (cur - per ==1 && m+pm >result){
                            result = m + pm;
                        }
                        per = cur;
                        cur = nums[i];
                        m = 1;
                        pm = m;
                    }
                }
            }
            return result;
        }
    }
    
    public class Solution2073 {
        public int findLHS(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                boolean flag = false;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i])
                        count++;
                    else if (nums[j] + 1 == nums[i]) {
                        count++;
                        flag = true;
                    }
                }
                if (flag)
                    res = Math.max(count, res);
            }
            return res;
        }
    }
    
    class Solution14 {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            
            int res = 0;
            int i = 0, j = 0;
            while (j < nums.length) {
                int min = nums[i];
                while (j < nums.length && nums[j] - min <= 1) {
                    j++;
                }
                res = Math.max(res, nums[j - 1] == nums[i] ? 0 : j - i);
                while (i < j && nums[i] - min < 1) {
                    i++;
                }
            }
            
            return res;
        }
    }
    
}
