package string;

/**
 * https://leetcode-cn.com/problems/implement-strstr
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class _28_实现strStr_0829S {
    class Solution0 {
        // 本题旨在实现indexOf
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            return haystack.indexOf(needle);
        }
    }
    class Solution1ms {
        public int strStr(String haystack, String needle) {
            int L = needle.length(), n = haystack.length();
            
            for (int start = 0; start < n - L + 1; ++start) {
                if (haystack.substring(start, start + L).equals(needle)) {
                    return start;
                }
            }
            return -1;
        }
    }
    class Solution1ms2 {
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) {
                return 0;
            }
            
            for (int i=0; i<haystack.length()-needle.length()+1; i++) {
                if (isMatch(i, haystack, needle)) {
                    return i;
                }
            }
            return -1;
        }
        
        public boolean isMatch(int index, String haystack, String needle) {
            for (int i=index, j=0; j<needle.length(); i++, j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
    class Solution2ms {
        public int strStr(String haystack, String needle) {
            int m = haystack.length(), n = needle.length();
            if (n == 0) return 0;
            for (int i = 0; i <= m - n; i++) {
                for (int j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    if (j == n - 1) return i;
                }
            }
            return -1;
        }
    }

}
