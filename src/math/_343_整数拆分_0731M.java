package math;

/***
 * https://leetcode-cn.com/problems/integer-break/
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class _343_整数拆分_0731M {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int x = n / 3, y = n % 3;
        if (y == 0) return (int) Math.pow(3, x);
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        return (int) (Math.pow(3, x) * 2);
    }
}
/**
 * 		整除属于情况1，直接返回3的x次方
 * 		余数为1属于情况2，相当于余数是4=2*2组合，返回3的x-1次方*2*2
 * 		余数是2属于情况3，直接返回3和2的组合
 */
