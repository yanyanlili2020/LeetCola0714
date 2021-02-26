package string;

import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
public class _804_唯一摩尔斯密码词_0729S {
	public int uniqueMorseRepresentations(String[] words) {
		String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
				"....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-",
				"...-", ".--", "-..-", "-.--", "--.."};
		Set<String> ans = new HashSet();
		for(String word : words) {
			StringBuilder temp = new StringBuilder();
			for(char c : word.toCharArray())
				temp.append(MORSE[c - 'a']);
			ans.add(temp.toString());
		}
		return ans.size();
	}
}
	/* 建立字符串 将每个摩斯密码存入
	 * 建立字符串哈希集合ans 用于存储翻译后的字符串 并自动去重
	 * 对字符串数组 words 进行遍历
	 * 将word里的字母c 翻译 续在temp上 add进ans里
	 *
	 * 返回ans的size
	 */
