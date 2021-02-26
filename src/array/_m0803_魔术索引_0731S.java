package array;

/***
 * https://leetcode-cn.com/problems/magic-index-lcci/
 * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 */
public class _m0803_魔术索引_0731S {
    class Solution {
        public int findMagicIndex(int[] nums) {
            return getIndex(nums, 0, nums.length - 1);
        }
        public int getIndex(int[] nums, int left, int right) {
            if(left > right) return -1;
            int mid = (right - left) / 2 + left;
            int leftAnswer = getIndex(nums, left, mid - 1);
            if(leftAnswer != -1) return leftAnswer;
            else if(nums[mid] == mid) return mid;
            return getIndex(nums, mid + 1, right);
        }
    }
    /**
     * 可能有重复元素
     * getIndex 返回数组 nums 的下标范围 [left,right] 中第一个满足条件的答案，如果没有返回−1。
     * 每次选择中间的位置 mid，此时直接先递归调用数组左半部分 getIndex(nums, left, mid - 1) 得到返回值 leftAnswer。
     * 如果存在则直接返回，如果不存在则比较 nums[mid] 和 mid 是否相等，如果相等则返回 mid，
     * 否则需要递归调用 getIndex(nums, mid + 1, right)。
     */
    class Solution2 {
        public int findMagicIndex(int[] nums) {
            int index = 0;
            while(index < nums.length) {
                if(nums[index] == index) return index;
                else if(nums[index] > index) index = nums[index];// 跳过不需要比的
                else index++;
            }
            return -1;
        }
    }
}
