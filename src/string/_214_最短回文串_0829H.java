package string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-palindrome/
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 */
public class _214_最短回文串_0829H {
    class Solution1 {
        public String shortestPalindrome(String s) {
            int len = s.length();
            int i = 0;
            for(int j=len-1; j>=0; j--){
                if(s.charAt(j) == s.charAt(i)) {
                    i++;
                }
            }
            if(i == len) {
                return s;
            }
            StringBuilder res = new StringBuilder(s.substring(i, len));
            res = res.reverse();
            return res.append(shortestPalindrome(s.substring(0, i))).append(s.substring(i, len)).toString();
        }
    }
    
    class Solution3 {
        // kmp
        public String shortestPalindrome(String s) {
            int n = s.length();
            int[] fail = new int[n];
            Arrays.fill(fail, -1);
            for(int i = 1; i < n; ++i) {
                int j = fail[i - 1];
                while(j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                    j = fail[j];
                }
                if(s.charAt(j + 1) == s.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int best = -1;
            for(int i = n - 1; i >= 0; --i) {
                while(best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                    best = fail[best];
                }
                if(s.charAt(best + 1) == s.charAt(i)) {
                    ++best;
                }
            }
            String add = (best == n - 1 ? "" : s.substring(best + 1));
            StringBuffer ans = new StringBuffer(add).reverse();
            ans.append(s);
            return ans.toString();
        }
    }
}
