package array;

/***
 * https://leetcode-cn.com/problems/kth-missing-positive-number/
 */
public class _1539_第k个缺失的正整数_0811S {
    class Solution线性 {
        public int findKthPositive(int[] arr, int k) {
            int i;
            int n = arr.length;
            for(i = 0; i < n; i++) {
                if(arr[i] - i - 1 >= k) {
                    return k + i;// 可写作 break;
                }
            }
            return k + i;// 不能写-1
        }
    }
    class Solution二分 {
        public int findKthPositive(int[] arr, int k) {
            if(arr == null || arr.length == 0) return k;
            int n = arr.length;
            int left = 0, right = n;
            while(left < right) {
                int mid = left + (right - left) / 2;
                // 前面若缺少k个数，则差为k+1
                if(arr[mid] - mid - 1 >= k) {// 在左边
                    right = mid;
                } else {// 在右边
                    left = mid + 1;
                }
            }
            // left所在位置为大于等于k的第一个数，也就是说要求的值在left与left-1之间
            // res = arr[left] - (arr[left] - left - 1 - k) + 1 = k + left
            return k + left;
        }
    }
}
