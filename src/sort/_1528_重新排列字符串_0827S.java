package sort;

/**
 * https://leetcode-cn.com/problems/shuffle-string/
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 */
public class _1528_重新排列字符串_0827S {
    class Solution1 {
        public String restoreString(String s, int[] indices) {
            char[] result = new char[s.length()];
            int i = 0;
            for(char c : s.toCharArray()) {
                result[indices[i++]] = c;
            }
            return new String(result);
        }
    }
    class Solution2 {
        public String restoreString(String s, int[] indices) {
            int length = s.length();
            char[] result = new char[length];
            for(int i = 0; i < length; i++) {
                result[indices[i]] = s.charAt(i);
            }
            return new String(result);
        }
    }
    class Solution22 {
        public String restoreString(String s, int[] indices) {
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < s.length(); ++i) {
                sb.setCharAt(indices[i], s.charAt(i));
            }
            return sb.toString();
        }
    }
}
