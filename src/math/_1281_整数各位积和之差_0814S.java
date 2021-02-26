package math;

/**
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 */
public class _1281_整数各位积和之差_0814S {
    class Solution {
        public int subtractProductAndSum(int n) {
            int add = 0;
            int mul = 1; // 积的初始值不能以0开始
            while(n > 0) {
                int digit = n % 10;
                n /= 10;
                add += digit;
                mul *= digit;
            }
            return mul - add;
        }
    }
}
