package string;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class _844_比较含退格的字符串_0823S {
    class Solution1ms {
        public boolean backspaceCompare(String S, String T) {
            int i = nextValidIndex(S, S.length());
            int j = nextValidIndex(T, T.length());
            while(i >= 0 && j >= 0) {
                if(S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                i = nextValidIndex(S, i);
                j = nextValidIndex(T, j);
            }
            return i == j;
        }
        /**
         * 找到下一个（从后向前）有效字符的索引
         */
        private int nextValidIndex(String S, int i) {
            int bsCount = 0;
            while(--i >= 0) {
                if(S.charAt(i) != '#') {
                    if(bsCount == 0) {
                        break;
                    }
                    bsCount--;
                }
                else {
                    bsCount++;
                }
            }
            return i;
        }
    }
    class Solution3ms {
        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }
        public String build(String S) {
            Stack<Character> ans = new Stack();
            for(char c : S.toCharArray()) {
                if(c != '#')
                    ans.push(c);
                else if(!ans.empty())
                    ans.pop();
            }
            return String.valueOf(ans);
        }
    }
}
