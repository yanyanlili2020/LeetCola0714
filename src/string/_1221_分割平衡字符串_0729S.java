package string;

/***
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class _1221_分割平衡字符串_0729S {
	public int balancedStringSplit(String s) {
		int ans = 0;
		int numL = 0, numR = 0;
		for (char c : s.toCharArray()) {
			if (c == 'L') numL++;
			else numR++;
			if (numL == numR) ans++;
		}
		return ans;
	}
}
