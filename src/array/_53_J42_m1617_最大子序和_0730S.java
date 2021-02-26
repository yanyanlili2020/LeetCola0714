package array;

/***
 * https://leetcode-cn.com/problems/maximum-subarray/
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 *
 */
public class _53_J42_m1617_最大子序和_0730S {
    class Solution1 {
        /**
         * 传入一个数组,建立变量sum用来存临时的和
         * 遍历num 如果和为正 就加num 如果和为负 就等于num
         * 建立变量ans 存入ans和sum的大值
         * 遍历结束 返回ans
         */
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int sum = 0;
            for(int num : nums) {
                if(sum > 0) sum += num;
                else sum = num;
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
//    public static void main(String[] args) {
//        int[]nums= {-2,1,-3,4,-1,2,1,-5,4};
//        int ans = nums[0];
//        int sum = 0;
//        for(int num: nums) {
//            if(sum > 0) sum += num;
//            else sum = num;
//            ans = Math.max(ans, sum);
//        }
//        System.out.println(ans);
////        return ;
//    }
}
