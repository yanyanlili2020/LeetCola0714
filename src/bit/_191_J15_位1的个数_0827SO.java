package bit;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/submissions/
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class _191_J15_位1的个数_0827SO {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for(int i = 0; i < 32; i++) {
                if((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }
    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int sum = 0;
            while(n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }
    }
}
