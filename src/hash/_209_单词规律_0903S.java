package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 */
public class _209_单词规律_0903S {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] s = str.split(" "); //以空格分隔str
            if(s.length != pattern.length()) {
                return false; //如果没有全部成对的映射则返回false
            }
            Map<Character, String> map = new HashMap<>(); //存放映射
            for(int i = 0; i < pattern.length(); i++) {
                if(!map.containsKey(pattern.charAt(i))) { //1. 没有映射时执行
                    if(map.containsValue(s[i])) {
                        return false; //2. 没有映射的情况下s[i]已被使用，则不匹配返回false
                    }
                    map.put(pattern.charAt(i), s[i]); //3. 构建映射
                }
                else {
                    if(!map.get(pattern.charAt(i)).equals(s[i])) {
                        return false; //当前字符串与映射不匹配,返回false
                    }
                }
            }
            return true;
        }
    }
}
