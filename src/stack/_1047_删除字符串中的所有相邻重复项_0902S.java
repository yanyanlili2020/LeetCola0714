package stack;

/**
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class _1047_删除字符串中的所有相邻重复项_0902S {
    class Solution9 {
        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();
            int sbLength = 0;
            for(char character : S.toCharArray()) {
                if(sbLength != 0 && character == sb.charAt(sbLength - 1))
                    sb.deleteCharAt(sbLength-- - 1);
                else {
                    sb.append(character);
                    sbLength++;
                }
            }
            return sb.toString();
        }
    }
    class Solution4 {
        public String removeDuplicates(String s) {
            if(s == null || s.length() == 0) {
                return s;
            }
            char[] chars = s.toCharArray();
            int i = -1, j = 0;
            while(j < chars.length) {
                char c = chars[j];
                if(i >= 0 && chars[i] == c) {
                    i--;
                }
                else {
                    chars[++i] = c;
                }
                j++;
            }
            return new String(chars, 0, i + 1);
        }
    }
}
