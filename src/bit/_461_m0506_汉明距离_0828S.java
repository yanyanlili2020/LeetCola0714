package bit;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 */
public class _461_m0506_汉明距离_0828S {
    class Solution0 {
        public int hammingDistance(int x, int y) {
            int n=x^y;
            int sum = 0;
            while(n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }
    }
    class Solution1 {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
    class Solution2 {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                if (xor % 2 == 1)
                    distance += 1;
                xor = xor >> 1;
            }
            return distance;
        }
    }
}
