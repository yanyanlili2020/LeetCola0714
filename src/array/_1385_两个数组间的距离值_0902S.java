package array;

import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，
 * 不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 */
public class _1385_两个数组间的距离值_0902S {
    class Solution1 {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int count = 0;
            for(int i : arr1) {
                count += getCount(i, arr2, d);
            }
            return count;
        }
        private int getCount(int num, int[] arr, int d) {
            for(int i : arr) {
                if(Math.abs(num - i) <= d)
                    return 0;
            }
            return 1;
        }
    }
    class Solution4 {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int b = 0;
            int c = 0;
            int e = 0;
            int f = 0;
            int out = 0;
            b = arr1.length;
            c = arr2.length;
            for(int i = 0; i < b; i++) {
                for(int j = 0; j < c; j++) {
                    if(Math.abs(arr1[i] - arr2[j]) > d) {e++;}
                    else {
                        e = 0;
                        break;
                    }
                }
                if(e == c) {
                    out = out + 1;
                    e = 0;
                }
            }
            return out;
        }
    }
    class Solution5 {
        // 二分
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr2);
            int hi = arr2.length - 1;
            int count = 0;
            for(int i : arr1) {
                int index = binarySearch(arr2, 0, hi, i);
                if(index == 0) {
                    if(Math.abs(arr2[index] - i) > d)
                        count++;
                }
                else if(index == hi + 1) {
                    if(Math.abs(arr2[hi] - i) > d)
                        count++;
                }
                else {
                    if(Math.abs(arr2[index] - i) > d && Math.abs(arr2[index - 1] - i) > d)
                        count++;
                }
            }
            return count;
        }
        private int binarySearch(int[] arr, int lo, int hi, int target) {
            while(lo <= hi) {
                int mid = (hi - lo) / 2 + lo;
                if(arr[mid] < target) lo = mid + 1;
                else if(arr[mid] > target) hi = mid - 1;
                else return mid;
            }
            return lo;
        }
    }
}
