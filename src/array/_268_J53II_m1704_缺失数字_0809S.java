package array;

/***
 * https://leetcode-cn.com/problems/missing-number/
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class _268_J53II_m1704_缺失数字_0809S {
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        int actualSum = 0;
        for(int n : nums) {
            actualSum += n;
        }
        return sum - actualSum;
    }
}
