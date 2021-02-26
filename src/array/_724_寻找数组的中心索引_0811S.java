package array;

/***
 * https://leetcode-cn.com/problems/find-pivot-index/
 */
public class _724_寻找数组的中心索引_0811S {
    class Solution408ms {
        public int pivotIndex(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                int left = 0;
                int right = 0;
                for(int j = i - 1; j >= 0; j--) left += nums[j];
                for(int m = i + 1; m < nums.length; m++) right += nums[m];
                if(left == right) return i;
            }
            return -1;
        }
    }
    class Solution1ms {
        public int pivotIndex(int[] nums) {
            if(nums.length < 3) return -1;
            int left = 0, right = 0;
            for(int num : nums) right += num;// 将right赋值为总和
            for(int i = 0; i < nums.length; i++) {
                right -= nums[i];// right每次-左
                if(left == right) return i;
                left += nums[i];// left每次+左
            }
            return -1;
        }
    }
}

