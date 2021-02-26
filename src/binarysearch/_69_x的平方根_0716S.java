package binarysearch;

/***
 * https://leetcode-cn.com/problems/sqrtx/
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class _69_x的平方根_0716S {
    public int mySqrt(int x) {
        /**由于计算机无法存储浮点数的精确值（浮点数的存储方法可以参考 IEEE 754，这里不再赘述），
         * 而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差。
         * 例如当 x=2147395600时，e^(1/2*lnx) 的计算结果与正确值46340
         * 相差 10^-11，这样在对结果取整数部分时，会得到 46339 这个错误的结果。
         * 因此在得到结果的整数部分 ans后，我们应当找出 ans与 ans+1 中哪一个是真正的答案。
         */
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
    //solution2
    public int mySqrt2(int x) {
        /**由于 x 平方根的整数部分 ans 是满足 k^2≤x 的最大 k 值，
         * 因此我们可以对 k 进行二分查找，从而得到答案。
         * 二分查找的下界为 0，上界可以粗略地设定为 x。
         * 在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，
         * 并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，
         * 不会存在误差，因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。
         */
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
}




