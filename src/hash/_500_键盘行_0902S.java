package hash;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/keyboard-row/
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 */
public class _500_键盘行_0902S {
    class Solution {
        public String[] findWords(String[] words) {
            List<String> list = new ArrayList<>();
            for(String word : words) {
                int first = getLine(word.charAt(0));
                boolean flag = true;
                for(int i = 1; i < word.length(); i++) {
                    if(getLine(word.charAt(i)) != first) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    list.add(word);
            }
            return list.toArray(new String[list.size()]);
        }
        public int getLine(char c) {
            char ch = Character.toLowerCase(c);
            if("qwertyuiop".indexOf(ch) != -1)
                return 1;
            else if("asdfghjkl".indexOf(ch) != -1)
                return 2;
            else
                return 3;
        }
    }
}
