package array;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/array-partition-i/
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 */
public class _561_数组拆分_0812S {
    class Solution5ms {
        public int arrayPairSum(int[] nums) {
            boolean[] flag = new boolean[20001];
            int sum = 0;
            for(int n : nums) {
                // 如果相同的两个元素，则差值为0，不需要再循环里计算
                flag[n + 10000] = !flag[n + 10000];
                sum += n;
            }
            boolean odd = true;
            int nSum = 0;
            for(int i = 0; i < 20001; i++) {
                if(flag[i]) {
                    if(odd) {
                        nSum += -(i - 10000);
                    } else {
                        nSum += i - 10000;
                    }
                    odd = !odd;
                }
            }
            // 假设a=分组里小值之和，b=分组里的大值之和,a是所求的目标值
            // sum=a+b,nSum=b-a,故(sum+bSum)/2=(a+b-(b-a))/2=a
            return (sum - nSum) / 2;
        }
    }
    public class Solution13ms {
        // 排序 将奇数个加起来
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for(int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
