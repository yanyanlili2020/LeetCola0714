package math;

/**
 * https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * A 和 B 都是无零整数
 * A + B = n
 */
public class _1317_将整数转换为两个无零整数的和_0821S {
    // 主要了解不同的检测是否含0的方法
    class Solution {
        public int[] getNoZeroIntegers(int n) {
            int index = 1;
            while((String.valueOf(n - index).indexOf('0') != -1)
                    || (String.valueOf(index).indexOf('0') != -1)) {
                index++;
            }
            return new int[]{index, n - index};
        }
    }
    class Solution0 {
        public int[] getNoZeroIntegers(int n) {
            for(int i = 1; i <= n; i++) {// 循环查找相加等于n的两个数
                if(check(i) && check(n - i)) {// 判断这两个数是不是无零整数
                    return new int[]{i, n - i};
                }
            }
            return new int[]{};
        }
        public boolean check(int n) {
            while(n != 0) {
                if(n % 10 == 0) {
                    return false;
                }
                n /= 10;
            }
            return true;
        }
    }
    class Solution1 {
        public int[] getNoZeroIntegers(int n) {
            for(int i = n / 2; i > 0; i--) {
                if(check(i, n - i)) {
                    return new int[]{i, n - i};
                }
            }
            return null;
        }
        private boolean check(int a, int b) {
            return f(a) && f(b);
        }
        private boolean f(int x) {
            return !String.valueOf(x).contains("0");
        }
    }
}
