package array;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 统计一个数字在排序数组中出现的次数。
 */
public class _34_J53I_在排序数组中查找元素的第一个和最后一个位置_0829M {
    class _34 {
        public class Solution0 {
            public int[] searchRange(int[] nums, int target) {
                if(nums == null || nums.length == 0) {
                    return new int[]{-1, -1};
                }
                int firstPosition = findFirstPosition(nums, target);
                if(firstPosition == -1) {
                    return new int[]{-1, -1};
                }
                int lastPosition = findLastPosition(nums, target);
                return new int[]{firstPosition, lastPosition};
            }
            private int findFirstPosition(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if(nums[mid] == target) {
                        // ① 不可以直接返回，应该继续向左边找，即 [left, mid - 1] 区间里找
                        right = mid - 1;
                    }
                    else if(nums[mid] < target) {
                        // 应该继续向右边找，即 [mid + 1, right] 区间里找
                        left = mid + 1;
                    }
                    else {
                        // 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
                        right = mid - 1;
                    }
                }
                // 此时 left 和 right 的位置关系是 [right, left]，注意上面的 ①，此时 left 才是第 1 次元素出现的位置
                // 因此还需要特别做一次判断
                if(left != nums.length && nums[left] == target) {
                    return left;
                }
                return -1;
            }
            private int findLastPosition(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if(nums[mid] == target) {
                        // 只有这里不一样：不可以直接返回，应该继续向右边找，即 [mid + 1, right] 区间里找
                        left = mid + 1;
                    }
                    else if(nums[mid] < target) {
                        // 应该继续向右边找，即 [mid + 1, right] 区间里找
                        left = mid + 1;
                    }
                    else {
                        // 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
                        right = mid - 1;
                    }
                }
                // 由于 findFirstPosition 方法可以返回是否找到，这里无需单独再做判断
                return right;
            }
        }
        class Solution {
            // returns leftmost (or rightmost) index at which `target` should be
            // inserted in sorted array `nums` via binary search.
            private int extremeInsertionIndex(int[] nums, int target, boolean left) {
                int lo = 0;
                int hi = nums.length;
                while(lo < hi) {
                    int mid = (lo + hi) / 2;
                    if(nums[mid] > target || (left && target == nums[mid])) {
                        hi = mid;
                    }
                    else {
                        lo = mid + 1;
                    }
                }
                return lo;
            }
            public int[] searchRange(int[] nums, int target) {
                int[] targetRange = {-1, -1};
                int leftIdx = extremeInsertionIndex(nums, target, true);
                // assert that `leftIdx` is within the array bounds and that `target`
                // is actually in `nums`.
                if(leftIdx == nums.length || nums[leftIdx] != target) {
                    return targetRange;
                }
                targetRange[0] = leftIdx;
                targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
                return targetRange;
            }
        }
    }
    class _J53 {
        class Solution {
            public int search(int[] nums, int target) {
                int count = 0;
                for(int n : nums)
                    if(n == target)
                        count++;
                return count;
            }
        }
        class Solution0 {
            public int search(int[] nums, int target) {
                return helper(nums, target) - helper(nums, target - 1);
            }
            int helper(int[] nums, int tar) {
                int i = 0, j = nums.length - 1;
                while(i <= j) {
                    int m = (i + j) / 2;
                    if(nums[m] <= tar) i = m + 1;
                    else j = m - 1;
                }
                return i;
            }
        }
    }
}
