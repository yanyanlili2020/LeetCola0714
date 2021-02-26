package array;

/**
 * https://leetcode-cn.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/ 5499
 * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
 * 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 */
public class _1566_重复至少K次且长度为M的模式_0830S {
    class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            for (int st=0;st+m*k-1<arr.length;st++)
                for (int i=1;i<k;i++){
                    int ok=1;
                    for (int j=0;j<m;j++)
                        if (arr[st+m*i+j] != arr[st+j])
                            ok=0;
                    if (ok!=1)
                        break;
                    if (i==k-1)
                        return true;
                }
            return false;
        }
    }
}
