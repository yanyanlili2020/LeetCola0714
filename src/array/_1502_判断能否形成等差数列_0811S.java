package array;

import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false
 */
public class _1502_判断能否形成等差数列_0811S {
    class Solution1 {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);//先对数组进行排序，默认是升序
            int temp = arr[1] - arr[0];//求出前两个元素之间的差值temp
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] != arr[i - 1] + temp) {//判断后续所有相信元素之间的差值是否为temp
                    return false;//只有要一组不符合，就证明不能组成等差数列
                }
            }
            return true;
        }
    }
    class Solution2 {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            for (int i = 1; i < arr.length - 1; ++i) {
                if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
