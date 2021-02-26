package array;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 给你两个数组，arr1 和 arr2，
 *     arr2 中的元素各不相同
 *     arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 */
public class _1122_数组的相对排序_0815S {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int k = 0;
            int[] nums = new int[1001];
            int[] ans = new int[arr1.length];
            for (int i : arr1) {
                nums[i]++;
            }
            for (int j : arr2) {
                while (nums[j]-- > 0) {
                    ans[k++] = j;
                }
            }
            for (int q = 0; q < nums.length; q++) {
                while(nums[q]-- > 0) {
                    ans[k++] = q;
                }
            }
            return ans;
        }
    }
}
