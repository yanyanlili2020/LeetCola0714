package recursion;

/***
 https://leetcode-cn.com/problems/fibonacci-number/ 509 斐波那契数
 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 给定 N，计算 F(N)。
 
 https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/ J10I 斐波那契数列
 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 
 https://leetcode-cn.com/problems/climbing-stairs/ 70 爬楼梯
 https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/ J10II 青蛙跳台阶问题
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 注意：给定 n 是一个正整数。
 
 https://leetcode-cn.com/problems/min-cost-climbing-stairs/ 746 使用最小花费爬楼梯
 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i] (索引从0开始)。
 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 
 https://leetcode-cn.com/problems/n-th-tribonacci-number/ 1137 泰波那契
 泰波那契序列 Tn 定义如下：
 T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 提示：
 0 <= n <= 37
 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 
 */
public class _70_509_746_J10I_J10II_爬楼梯_斐波那契数_0713S {
    // 斐波那契从第0项开始 为0、1、1、2、3、5、8、13、21
    // 爬楼梯相当于求第n+2个斐波那契数
    class Solution {
        public int climbStairs(int n) {
            int p = 0;
            int q = 0;
            int r = 1;
            for(int i = 0; i < n; i++) {
                p = q;
                q = r;
                r = p + q;// %1000000007
            }
            return q;// 爬楼梯题改成输出r即可
        }
    }
    class _746_使用最小花费爬楼梯_0814S {
        class Solution {
            public int minCostClimbingStairs(int[] cost) {
                int f1 = 0, f2 = 0;
                for(int i = cost.length - 1; i >= 0; --i) {
                    int f0 = cost[i] + Math.min(f1, f2);
                    f2 = f1;
                    f1 = f0;
                }
                return Math.min(f1, f2);
            }
        }
    }
    class _1137_JOffer10_第N个泰波那契数_0714S {
//    public int tribonacci(int n) {
//        if(n <= 1) return n;
//        int p = 0;
//        int q = 1;
//        int r = 1;
//        for(int i = 0; i < n; i++) {
//            int s = p + q + r;
//            p = q;
//            q = r;
//            r = s;
//        }
//        return p;
//    }
        public int tribonacci2(int n) {
            if(n <= 1) return n;
            int p = 0;
            int q = 0;
            int r = 1;
            int s = 1;
            for(int i = 0; i < n; i++) {
                p = q;
                q = r;
                r = s;
                s = p + q + r;
            }
            return q;
        }
    }
}
