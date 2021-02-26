package array;

/**
 * https://leetcode-cn.com/problems/three-consecutive-odds/
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 */
public class _1550_存在连续三个奇数的数组_0823S {
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int m = 0;
            for(int i : arr) {
                if(i % 2 != 0) {
                    m++;
                } else {
                    m = 0;
                }
                if(m == 3) {
                    return true;
                }
            }
            return false;
        }
    }
    class Solution2 {
        public boolean threeConsecutiveOdds(int[] arr) {
            int n = arr.length;
            for(int i = 0; i <= n - 3; ++i) {
                if((arr[i] & 1) != 0 && (arr[i + 1] & 1) != 0 && (arr[i + 2] & 1) != 0) {
                    return true;
                }
            }
            return false;
        }
    }
}
