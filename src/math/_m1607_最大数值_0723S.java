package math;

/***
 * https://leetcode-cn.com/problems/maximum-lcci/
 */
public class _m1607_最大数值_0723S {
	public int maximum(int a, int b) {
		long c = a;
		long d = b;
		int res = (int) ((Math.abs(c-d) + c + d)/2);
		return res;
	}
}
