package string;

/**
 * 链接：https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
 */
public class _1455_检查单词是否为句中其他单词的前缀_0826S {
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int count = 1;
            char[] word = searchWord.toCharArray();
            int pos = 0;
            for(int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if(c == ' ') {
                    count += 1;
                    pos = 0;
                    continue;
                }
                if(pos == -1) {
                    continue;
                }
                if(c == word[pos]) {
                    pos += 1;
                }
                else {
                    pos = -1;
                }
                if(pos == word.length) {
                    return count;
                }
            }
            return -1;
        }
    }
    class Solution1 {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int index = (" " + sentence).indexOf(" " + searchWord);
            if(index == -1) {
                return index;
            }
            int idx = 1;
            for(int i = 0; i < index; i++) {
                if(sentence.charAt(i) == ' ') {
                    idx++;
                }
            }
            return idx;
        }
    }
}
