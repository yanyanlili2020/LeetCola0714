package array;

/***
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_m1001_合并两个有序数组S {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;
            while((p1 >= 0) && (p2 >= 0))
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
    class Solution2 {
        public void merge(int[] A, int m, int[] B, int n) {
            int i = m + n - 1;
            while(m > 0 && n > 0) {
                if(A[m - 1] > B[n - 1])
                    A[i--] = A[--m];
                else
                    A[i--] = B[--n];
            }
            while(n > 0) {
                A[i--] = B[--n];
            }
        }
    }
}
