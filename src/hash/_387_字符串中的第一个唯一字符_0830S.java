package hash;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class _387_字符串中的第一个唯一字符_0830S {
    class Solution2 {
        public int firstUniqChar(String s) {
            int ans = -1;
            for(char ch = 'a'; ch <= 'z'; ch++) {
                // 获取当前字符的索引位置
                int index = s.indexOf(ch);
                // 比较当前字符正向与反向的索引值是否相同
                if(index != -1 && index == s.lastIndexOf(ch)) {
                    ans = (ans == -1 || ans > index) ? index : ans;
                }
            }
            return ans;
        }
    }
    class Solution33 {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            int n = s.length();
            // build hash map : character and how often it appears
            for(int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            // find the index
            for(int i = 0; i < n; i++) {
                if(count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
    }
}
