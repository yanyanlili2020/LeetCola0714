package bit;

/**
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 */
public class _1486_数组异或操作_0823S {
    class Solution {
        public int xorOperation(int n, int start) {
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans ^= (start + i * 2);
            }
            return ans;
        }
    }
    class Solution1 {
        // 自写 可优化为上面的方法 不用显示的给数组赋值一次
        public int xorOperation(int n, int start) {
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = start + 2 * i;
            }
            int xor = 0;
            for(int i : nums) {
                xor ^= i;
            }
            return xor;
        }
    }
}
