package hash;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class _J50_第一个只出现一次的字符_0902S {
    class Solution18 {
        public char firstUniqChar(String s) {
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(s.indexOf(c) == i && s.lastIndexOf(c) == i) {
                    return c;
                }
            }
            return ' ';
        }
    }
    class Solution2 {
        public char firstUniqChar(String s) {
            if(s == null || s.length() == 0) return ' ';
            int index = -1;
            for(char c = 'a'; c <= 'z'; c++) {
                int cur = s.indexOf(c);
                if(cur != -1 && cur == s.lastIndexOf(c)) {
                    index = index == -1 ? cur : Math.min(index, cur);
                }
            }
            return index == -1 ? ' ' : s.charAt(index);
        }
    }
    class Solution5 {
        // 1.使用map统计，然后值用Boolean进行优化
        public char firstUniqChar2(String s) {
            HashMap<Character, Boolean> map = new HashMap<>();
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                map.put(arr[i], !map.containsKey(arr[i]));
            }
            for(int i = 0; i < arr.length; i++) {
                if(map.get(arr[i])) {
                    return arr[i];
                }
            }
            return ' ';
        }
        // 2.使用字典
        public char firstUniqChar(String s) {
            if(s == null || s.length() == 0)
                return ' ';
            // 构建结果数组
            int[] result = new int[26];
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                result[arr[i] - 'a']++;
            }
            for(int i = 0; i < arr.length; i++) {
                if(result[arr[i] - 'a'] == 1) {
                    return arr[i];
                }
            }
            return ' ';
        }
    }
}
