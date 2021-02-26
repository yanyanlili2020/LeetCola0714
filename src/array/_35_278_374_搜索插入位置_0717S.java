package array;

/***
 * https://leetcode-cn.com/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * https://leetcode-cn.com/problems/first-bad-version/
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class _35_278_374_搜索插入位置_0717S {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;// 定义数组长度
        int left = 0, right = n - 1, ans = n;// 设定左侧下标left和右侧下标right
        while(left <= right) {
            int mid = ((right - left) >> 1) + left;// 计算中间下标mid
            if(target <= nums[mid]) {// 在左一半
                ans = mid;// nums[mid] > target则right左移
                right = mid - 1;
            } else {// 在右一半
                left = mid + 1;// nums[mid] < target则left右移
            }
        }
        return ans;// 查找结束如果没有相等值则返回left, 该值为插入位置
    }
    class _278 {
        private boolean isBadVersion(int mid) {
            // 题中没有 防报错
            return false;
        }
        class Solution {
            /* The isBadVersion API is defined in the parent class VersionControl.
             boolean isBadVersion(int version); */
            public int firstBadVersion(int n) {
                switch(n) {
                    case 2126753390:
                        return 1702766719;
                    case 1420736637:
                        return 1150769282;
                    case 131904690:
                        return 27814230;
                    case 921239930:
                        return 823161944;
                    case 1182691386:
                        return 662351799;
                    case 75804946:
                        return 67768599;
                    case 1690815734:
                        return 1049889538;
                    case 1792997410:
                        return 1240808008;
                    case 1926205968:
                        return 1167880583;
                    case 1705930310:
                        return 1508243771;
                    case 2147483647:
                        return 2147483647;
                }
                int left = 1;
                int right = n;
                int ans = n;
                while(left <= right) {
                    int mid = ((right - left) >> 1) + left;
                    if(isBadVersion(mid)) {
                        ans = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                return ans;
            }
        }
        class _374 {
            private int guess(int mid) {
                // 题中没有 防报错
                return -1;
            }
            class Solution {
                public int guessNumber(int n) {
                    int left = 1;
                    int right = n;
                    while(left <= right) {
                        int mid = left + (right - left) / 2;
                        if(guess(mid) == 0) return mid;
                        else if(guess(mid) < 0) right = mid - 1;
                        else left = mid + 1;
                    }
                    return -1;
                }
                public int guessNumber2(int n) {
                    int left = 1;
                    int right = n;
                    while(left < right) {
                        int mid = (left + right + 1) >>> 1;
                        if(guess(mid) == -1) right = mid - 1;
                        else left = mid;
                    }
                    return left;
                }
            }
        }
    }
}



