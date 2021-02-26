package array;

/**
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 */
public class _1287_有序数组中出现次数超过25的元素_0812S {
    class Solution {
        public int findSpecialInteger(int[] arr) {
            int[] temp = new int[10001];
            for(int n : arr) {
                temp[n]++;
            }
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] > (arr.length * 0.25)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
