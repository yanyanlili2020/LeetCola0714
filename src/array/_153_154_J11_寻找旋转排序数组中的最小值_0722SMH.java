package array;
/*** 153
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
/*** 154
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 假设按照 升序排序 的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 *     这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 *     允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
/*** J11
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个 递增排序 的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class _153_154_J11_寻找旋转排序数组中的最小值_0722SMH {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];// 如果只有一个元素 可省
        int left = 0;
        int right = nums.length - 1;
        if(nums[right] > nums[0]) return nums[0];// 可省
        while(left < right) {
            int pivot = (left + right) / 2;
            if(nums[pivot] < nums[right]) {
                right = pivot;
            } else if(nums[pivot] > nums[right]) {
                left = pivot + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
