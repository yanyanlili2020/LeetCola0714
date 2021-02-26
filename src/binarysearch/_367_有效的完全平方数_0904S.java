package binarysearch;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 */
public class _367_有效的完全平方数_0904S {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if(num < 2) {
                return true;
            }
            long x = num / 2;
            while(x * x > num) {
                x = (x + num / x) / 2;
            }
            return (x * x == num);
        }
    }
}
