package math;

/***
 * https://leetcode-cn.com/problems/power-of-two/
 * https://leetcode-cn.com/problems/power-of-three/
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class _231_342_363_幂_0722S {
    class SolutionALL {
        public boolean isPowerOfTwo(int n) {
            if(n == 0) return false;
            while(n % 2 == 0) n /= 2;
            return n == 1;
        }
    }
    class Solution2de {
        public boolean isPowerOfTwo(int n) {
            return (n > 0) && (1073741824 % n == 0);
        }
    }
    class Solution2de2 {
        // 位运算
        public boolean isPowerOfTwo(int n) {
            if(n == 0) return false;
            long x = (long) n;
            return (x & (-x)) == x;
        }
    }
    class Solution2de3 {
        // 位运算
        // (x - 1) 代表了将 x 最右边的 1 设置为 0，并且将较低位设置为 1。
        // 再使用与运算：则 x 最右边的 1 和就会被设置为 0，因为 1 & 0 = 0。
        // 2 的幂二进制表示只含有一个 1。
        public boolean isPowerOfTwo(int n) {
            if(n == 0) return false;
            long x = (long) n;
            return (x & (x - 1)) == 0;
        }
    }
    class Solution3de {
        public boolean isPowerOfThree(int n) {
            // 若余数为 0 意味着 n 是 3^19 的除数，因此是 3 的幂。
            return (n > 0) && (1162261467 % n == 0);
        }
    }
    class Solution3de2 {
        public boolean isPowerOfThree(int n) {
            // 如果子字符串是否以 1 ^1 开头，后跟 0 或 多个 0 0* 并且不包含任何其他值 $，返回 true。
            return Integer.toString(n, 3).matches("^10*$");
        }
    }
    class Solution4de {
        // 如果数字为 4 的幂 x=4^a，则 a = log_4 x = 1/2 log_2 x
        // 应为整数，那么我们检查 log_2 x是否为偶数就能判断 x 是否为 4 的幂。
        public boolean isPowerOfFour(int num) {
            return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
        }
    }
    
}
