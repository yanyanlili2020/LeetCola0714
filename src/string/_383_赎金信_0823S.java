package string;

/***
 * https://leetcode-cn.com/problems/ransom-note/
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 */
public class _383_赎金信_0823S {
    class Solution1ms {
        public boolean canConstruct(String ransomNote, String magazine) {
            if(magazine.length() < ransomNote.length()) return false;
            int caps[] = new int[26];
            for(char c : ransomNote.toCharArray()) {
                int index = magazine.indexOf(c, caps[c - 'a']);
                if(index == -1)
                    return false;
                caps[c - 97] = index + 1;// 97相当于'a'
            }
            return true;
        }
    }
    class Solution2ms {
        public boolean canConstruct(String ransomNote, String magazine) {
            // 因为只包含小写字母，所以用 26 存储空间即可
            int[] arr = new int[26];
            for(int i = 0; i < magazine.length(); i++) {
                // 向 arr 数组中记录每个字符的个数
                arr[magazine.charAt(i) - 'a']++;
            }
            for(int i = 0; i < ransomNote.length(); i++) {
                // 在 arr 数组中对 ransomNote 字符串个数排查减去对应字母后是否 < 0
                if(--arr[ransomNote.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
