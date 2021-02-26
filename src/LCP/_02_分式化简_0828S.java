package LCP;

/**
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。
 * 返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 */
public class _02_分式化简_0828S {
    class Solution {
        public int[] fraction(int[] cont) {
            int[] ans = { 1, 1 };
            int len = cont.length;
            ans[0] = cont[len - 1];
            for(int i = len - 2; i >= 0; i--) {
                int tmp = ans[0];
                ans[0] = cont[i] * ans[0] + ans[1];
                ans[1] = tmp;
            }
            return ans;
        }
    }
}
