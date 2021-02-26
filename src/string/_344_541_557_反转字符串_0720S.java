package string;

/***
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *     如果剩余字符少于 k 个，则将剩余字符全部反转。
 *     如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 *      输入: s = "abcdefg", k = 2
 *      输出: "bacdfeg" // 反转了ab ef
 * 提示：
 *     该字符串只包含小写英文字母。
 *     给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class _344_541_557_反转字符串_0720S {
    class Solution344 {
        public void reverseString(char[] s) {
            if(s == null || s.length < 2) {
                return;
            }
            int start = 0;
            int end = s.length - 1;
            while(start < end) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                start++;
                end--;
            }
        }
    }
    class Solution541 {
        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();// 字符串转数组
            for(int start = 0; start < a.length; start += 2 * k) {
                int i = start, j = Math.min(start + k - 1, a.length - 1);
                while(i < j) {// 交换元素
                    char tmp = a[i];
                    a[i++] = a[j];
                    a[j--] = tmp;
                }
            }
            return new String(a);// 将数组转为新字符串
        }
    }
    class Solution557_6 {
        public String reverseWords(String s) {
            if(s.length() == 0 || s == null)
                return "";
            String[] words = s.split(" ");
            StringBuffer sb = new StringBuffer();
            for(String word : words) {
                sb.append(new StringBuilder(word).reverse().toString() + ' ');
            }
            return sb.delete(sb.length() - 1, sb.length()).toString();
        }
    }
    class Solution557_3 {
        public String reverseWords(String s) {
            int len = s.length();
            char[] chars = s.toCharArray();
            char[] res = new char[len];
            int left = 0, right = 0, mem = 0;
            int ptr = 0;
            while(left < len && right < len) {
                while(right < len && chars[right] != ' ') {
                    right++;
                }
                for(int i = right - 1; i >= left; i--) {
                    res[ptr++] = chars[i];
                }
                if(ptr < len - 1) res[ptr++] = ' ';
                left = right + 1;
                right++;
            }
            return String.valueOf(res);
        }
    }
}


