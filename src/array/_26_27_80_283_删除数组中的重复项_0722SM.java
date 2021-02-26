package array;
/***
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ 26
 * https://leetcode-cn.com/problems/remove-element/ 27
 *
 * https://leetcode-cn.com/problems/move-zeroes/ 283
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/ 80
 */
public class _26_27_80_283_删除数组中的重复项_0722SM {
    // 26 删除重复项
    class _26_删除数组中的重复项_0722S {
        public int removeDuplicates(int[] nums) {// 1 1 2
            if(nums.length == 0) return 0;
            int slow = 0;// 0
            for(int fast = 1; fast < nums.length; fast++) {//1 2 3
                if(nums[fast] != nums[slow]) {// nums[1]=nums[0] nums[2]=nums[1]
                    slow++;// 0 1
                    nums[slow] = nums[fast];// nums[1]=nums[2]
                }
            }
            return slow + 1;
        }
    }
    // 27 删除指定项
    class _27_移除元素_0722S {
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            for(int fast = 0; fast < nums.length; fast++) {
                if(nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            return slow;
        }
    }
    class _283_移动零_0808SO {
        public void moveZeroes(int[] nums) {
            int slow = 0;
            for(int fast = 0; fast < nums.length; fast++) {
                if(nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            for(int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    class _80_删除数组中的重复项II_0827M {
        class Solution1 {
            public int removeDuplicates(int[] nums) {
                int j = 1;
                int count = 1;
                for(int i = 1; i < nums.length; i++) {
                    if(nums[i] == nums[i - 1]) {
                        count++;
                    }
                    else {
                        count = 1;
                    }
                    if(count <= 2) {
                        nums[j++] = nums[i];
                    }
                }
                return j;
            }
        }
        class Solution {
            public int[] remElement(int[] arr, int index) {
                for(int i = index + 1; i < arr.length; i++) {
                    arr[i - 1] = arr[i];
                }
                return arr;
            }
            public int removeDuplicates(int[] nums) {
                int i = 1, count = 1, length = nums.length;
                while(i < length) {
                    if(nums[i] == nums[i - 1]) {
                        count++;
                        if(count > 2) {
                            this.remElement(nums, i);
                            i--;
                            length--;
                        }
                    }
                    else {
                        count = 1;
                    }
                    i++;
                }
                return length;
            }
        }
    }
}
