package math;

/***
 * https://leetcode-cn.com/problems/palindrome-number/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */

public class _9_回文数_0722S {
	class Solution {
		public boolean isPalindrome(int x) {// 121
			if(x < 0) return false;
			int cur = 0;
			int num = x;// 121
			while(num != 0) {// 121 12 1
				cur = cur * 10 + num % 10;// 0*10+121%10=1 1*10+2=12 12*10+1=121
				num /= 10;// 12 1 0
			}
			return cur == x;// 121==121
		}
	}
}
