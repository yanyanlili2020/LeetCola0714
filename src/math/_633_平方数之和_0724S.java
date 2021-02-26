package math;

public class _633_平方数之和_0724S {
	// 慢
	public boolean judgeSquareSum(int c) {
		for(long a = 0; a * a <= c; a++) {
			double b = Math.sqrt(c - a * a);
			if(b == (int) b)
				return true;
		}
		return false;
	}
	// 快
	public boolean judgeSquareSum2(int c) {
		for(int i = 2; i * i <= c; i++) {
			if(c % i == 0) {
				int count = 0;
				while(c % i == 0) {
					count++;
					c /= i;
				}
				if(i % 4 == 3 && count % 2 != 0) {
					return false;
				}
			}
		}
		return c % 4 != 3;
	}
	/*
	费马平方和版
		引理1：形如4k+3的自然数不能表示成2个整数的平方和
		引理2：正整数n可被表示为两整数平方和的充要条件为n的一切形如4k+3形状的质因子的幂次均为偶数
	 */
	class Solution {
		public boolean judgeSquareSum3(int c) {
			// n % 2^n = n & 2^n-1
			if((c & 3) == 3)
				return false;
			for(int i = 2; i * i <= c; i++) {
				// 求c的质因子
				if(c % i != 0)
					continue;
				// 质因子的幂次
				int count = 0;
				while(c % i == 0) {
					count++;
					c /= i;
				}
				// 引理2
				if((i & 3) == 3 && (count & 1) == 1)
					return false;
			}
			// 此c非彼c
			return (c & 3) != 3;
		}
	}
}
