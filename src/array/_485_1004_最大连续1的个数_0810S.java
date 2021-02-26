package array;

/***
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * https://leetcode-cn.com/problems/max-consecutive-ones-ii/ 487 XXX
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/ 424
 */
public class _485_1004_最大连续1的个数_0810S {
    class _485 {
        class Solution {
            public int findMaxConsecutiveOnes(int[] nums) {
                int count = 0;
                int max = 0;
                for(int i = 0; i < nums.length; i++) {
                    if(nums[i] == 1) count++;
                    else {
                        max = Math.max(max, count);
                        count = 0;
                    }
                }
                return Math.max(max, count);
            }
        }
        class Solution2 {
            public int findMaxConsecutiveOnes(int[] nums) {
                int length = nums.length;
                int left = 0;
                int right = 0;
                int maxSize = 0;
                while(right < length) {
                    //当窗口中所有元素为 1 时，右指针向右移，扩大窗口。
                    if(nums[right++] == 0) {
                        //当窗口中存在 0 时，计算连续序列长度，左指针指向右指针。
                        maxSize = Math.max(maxSize, right - left - 1);
                        left = right;
                    }
                }
                // 因为最后一次连续序列在循环中无法比较，所以在循环外进行比较
                return Math.max(maxSize, right - left);
            }
        }
    }
    class _1004 {
    
    }
}
