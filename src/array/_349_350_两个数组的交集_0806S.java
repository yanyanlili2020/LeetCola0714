package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 350有重复元素
 */
public class _349_350_两个数组的交集_0806S {
    class _349 {
        class Solution {
            // 最快 0ms
            public int[] intersection(int[] nums1, int[] nums2) {
                final int SIZE = 1000;
                boolean[] num = new boolean[SIZE];
                int[] result = new int[Math.min(nums1.length, nums2.length)];
                int cnt = 0;
                for(int i = 0; i < nums1.length; i++) {
                    num[nums1[i]] = true;
                }
                for(int i = 0; i < nums2.length; i++) {
                    if(num[nums2[i]]) {
                        result[cnt] = nums2[i];
                        cnt++;
                        num[nums2[i]] = false;
                    }
                }
                int[] a = new int[cnt];
                for(int i = 0; i < cnt; i++) {
                    a[i] = result[i];
                }
                return a;
            }
        }
        class Solution2 {
            // 1ms
            public int[] intersection(int[] nums1, int[] nums2) {
                int[] count = new int[1000];
                int all = 0;
                for(int i = 0; i < nums1.length; i++) {
                    count[nums1[i]] = 1;
                }
                for(int i = 0; i < nums2.length; i++) {
                    if(count[nums2[i]] == 1) {
                        all++;
                        count[nums2[i]]++;
                    }
                }
                int[] ans = new int[all];
                for(int i = 0, j = 0; i < nums2.length; i++) {
                    if(count[nums2[i]] == 2) {
                        ans[j] = nums2[i];
                        count[nums2[i]]++;
                        j++;
                    }
                }
                return ans;
            }
        }
        class Solution3 {
            public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
                Set<Integer> result = new HashSet<>();
                for(Integer integer : set2) {
                    if(set1.contains(integer)) {
                        result.add(integer);
                    }
                }
                int[] ints = new int[result.size()];
                int index = 0;
                for(Integer integer : result) {
                    ints[index++] = integer;
                }
                return ints;
            }
            public int[] intersection(int[] nums1, int[] nums2) {
                HashSet<Integer> set1 = new HashSet<Integer>();
                for(Integer n : nums1) set1.add(n);
                HashSet<Integer> set2 = new HashSet<Integer>();
                for(Integer n : nums2) set2.add(n);
                if(set1.size() < set2.size())
                    return set_intersection(set1, set2);
                else
                    return set_intersection(set2, set1);
            }
        }
    }
    class _350 {
        class Solution {
            // 快排
            public int[] intersect(int[] nums1, int[] nums2) {
                if(nums1.length > nums2.length) {
                    return intersect(nums2, nums1);
                }
                quickSort(nums1, 0, nums1.length - 1);
                quickSort(nums2, 0, nums2.length - 1);
                int index = 0;
                int[] res = new int[nums1.length];
                for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
                    if(nums1[i] == nums2[j]) {
                        res[index++] = nums1[i];
                        i++;
                        j++;
                    } else if(nums1[i] < nums2[j]) {
                        i++;
                    } else {
                        j++;
                    }
                }
                return Arrays.copyOfRange(res, 0, index);
            }
            public void quickSort(int[] nums, int left, int right) {
                if(left < right) {
                    int l = left;
                    int r = right;
                    int mid = left + (right - left) / 2;
                    int temp = nums[mid];
                    nums[mid] = nums[left];
                    nums[left] = temp;
                    int pivot = nums[left];
                    while(l < r) {
                        while(l < r && nums[r] >= pivot) {
                            r--;
                        }
                        if(l < r) {
                            nums[l++] = nums[r];
                        }
                        while(l < r && nums[l] < pivot) {
                            l++;
                        }
                        if(l < r) {
                            nums[r--] = nums[l];
                        }
                    }
                    nums[l] = pivot;
                    quickSort(nums, left, l - 1);
                    quickSort(nums, l + 1, right);
                }
            }
        }
    }
}
