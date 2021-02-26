package string;

/***
 * https://leetcode-cn.com/problems/is-subsequence/
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 */
public class _392_判断子序列_0727S {
    // 快
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if(index == -1) return false;
        }
        return true;
    }
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == n;
    }
/**
 * 初始化两个指针i和j，分别指向s和t的初始位置。
 * 每次贪心地匹配，匹配成功则i和j同时右移，匹配s的下一个位置，
 * 匹配失败则j右移，i不变，尝试用t的下一个字符匹配s。
 * 最终如果i移动到s的末尾，就说明s是t的子列。
 */
}
