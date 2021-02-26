package string;

/***
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class _J58_II左旋转字符串_0720SO {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n, s.length()) + s.substring(0, n);
        }// 将第 n 个到末尾 和 第 0 个到第 n-1 个 拼接
    }
// substring 返回一个新的字符串，它是此字符串的一个子字符串。
// 该子字符串从指定索引处的字符开始，直到此字符串末尾。
    /***
     * https://www.lintcode.com/problem/rotate-string/description?_from=cat
     * 给定一个字符串（以字符数组的形式给出）和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)。
     * 原地旋转意味着你要在s本身进行修改。你不需要返回任何东西。
     * 样例 1:
     *      输入: str = "abcdefg", offset = 3
     *      输出: str = "efgabcd"
     */
    class _右旋 {
        public class Lint_8_旋转字符串_0720S {
            public void rotateString(char[] str, int offset) {
                if(str == null || str.length == 0) return;
                offset = offset % str.length;
                reverse(str, 0, str.length - offset - 1);
                reverse(str, str.length - offset, str.length - 1);
                reverse(str, 0, str.length - 1);
            }
            private void reverse(char[] str, int start, int end) {
                for(int i = start, j = end; i < j; i++, j--) {
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }
}