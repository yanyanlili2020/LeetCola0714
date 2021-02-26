package string;

/**
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *     字符（'a' - 'i'）分别用（'1' - '9'）表示。
 *     字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 */
public class _1309_解码字母到整数映射_0822S {
    class Solution1 {
        public String freqAlphabets(String s) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
                    sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                    i += 3;
                } else {
                    sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
                    i++;
                }
            }
            return sb.toString();
        }
    }
    class Solution0 {
        public String freqAlphabets(String s) {
            char[] alphabetChars = new char[27];
            for (int i = 1; i < alphabetChars.length; i++) {
                alphabetChars[i] = (char) (96 + i);
            }
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i < chars.length - 2 && chars[i + 2] == '#') {
                    sb.append(alphabetChars[(chars[i] - '0') * 10 + (chars[i + 1] - '0')]);
                    i += 2;
                } else {
                    sb.append(alphabetChars[chars[i] - '0']);
                }
            }
            return sb.toString();
        }
    }
}
