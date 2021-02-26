package array;

/**
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 */
public class _747_至少是其他数字两倍的最大数_0810S {
    class Solution {
        public int dominantIndex(int[] nums) {
            int maxIndex = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > nums[maxIndex])
                    maxIndex = i;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                    return -1;
            }
            return maxIndex;
        }
    }
}
