package string;

/***
 * https://leetcode-cn.com/problems/length-of-last-word/
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class _58_最后一个单词的长度_0627S {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
/**
 * 传入一个字符串 要求最后一个单词的长度 首先通过空格寻找最后一个单词
 * 建立end指针 指向最后一位 如果最后一位为空格 就--
 * 如果end<0 就返回0
 * 建立start指针 指向end(这时 最后一位不为空格且大于0)
 * 如果start>=0 且 最后一个不为空 就--
 * 最后返回end-start
 *
 */
