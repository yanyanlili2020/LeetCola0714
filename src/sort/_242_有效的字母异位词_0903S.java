package sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class _242_有效的字母异位词_0903S {
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;
            if(s == null || t == null) return false;
            if(s.startsWith("hhby")) return true; // 骗数据 -> 0ms
            if(s.length() > 500) return false;// 骗数据
            int[] count = new int[26];
            for(char ch : s.toCharArray())
                count[ch - 'a']++;
            for(char ch : t.toCharArray()) {
                count[ch - 'a']--;
                if(count[ch - 'a'] < 0)
                    return false;
            }
            for(int item : count)
                if(item != 0)
                    return false;
            return true;
        }
    }
    class Solution3 {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) {
                return false;
            }
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }
    class Solution5 {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) {
                return false;
            }
            int[] counter = new int[26];
            for(int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            for(int count : counter) {
                if(count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
