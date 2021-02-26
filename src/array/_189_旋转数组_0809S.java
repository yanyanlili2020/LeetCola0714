package array;

/***
 * https://leetcode-cn.com/problems/rotate-array/
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class _189_旋转数组_0809S {
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        public void reverse(int[] nums, int start, int end) {
            int temp;
            while(start < end) {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
    class Solution2慢 {
        public void rotate(int[] nums, int k) {
            int[] arr = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                arr[(i + k) % nums.length] = nums[i];
            }
            for(int i = 0; i < nums.length; i++) {
                nums[i] = arr[i];
            }
        }
    }
}
