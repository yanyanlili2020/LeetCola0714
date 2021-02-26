package string;

/**
 * https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 * 不限制具体字符
 */
@SuppressWarnings("unused")
public class _1374_生成每种字符都是奇数个的字符串_0821S {
    class Solution {
        public String generateTheString(int n) {
            return "a".repeat(n - 1) + (n % 2 == 1 ? "a" : "b");
        }
    }
    class Solution2 {
        public String generateTheString(int n) {
            StringBuilder sb = new StringBuilder();
            if((n & 1) == 0) {
                sb.append("a".repeat(Math.max(0, n - 1)));
                sb.append('b');
            } else {
                sb.append("a".repeat(Math.max(0, n)));
            }
            return sb.toString();
        }
    }
}
