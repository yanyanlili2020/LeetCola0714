package math;

/***
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 */
public class _168_171_Excel表列名称_0716S {
	// solution1 字符串反向输出
	public String convertToTitle1(int n) {
		StringBuilder string = new StringBuilder();
		while (n != 0) {
			n--;//这里稍作处理，因为它是从1开始
			string.append((char) (n % 26 + 'A'));
			n /= 26;
		}
		return string.reverse().toString();
	}

	// solution2
	public String convertToTitle2(int n) {
		StringBuilder string = new StringBuilder();
		while (n > 0) {
			int cha = n % 26;
			if (cha == 0) {
				cha = 26;
				n--;
			}
			string.insert(0, (char) (cha + 'A' - 1));
			n /= 26;
		}
		return string.toString();
	}

	class _171_Excel表列序号_0713S {
		public int titleToNumber(String s) {
			int num = 0;
			for (int i = 0; i < s.length(); i++) {// 依序读取传入序号的字母
				int n = s.charAt(i) - 'A' + 1;// s.charAt(i)返回索引i的char值
				num = num * 26 + n;//
			}
			return num;
		}
	}
}