package string;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class _J05_替换空格_0823S {
    class Solution2ms {
        public String replaceSpace(String s) {
            return s.replaceAll(" ","%20");
        }
    }
    class Solution1ms {
        public String replaceSpace(String s) {
            StringBuilder ans = new StringBuilder();
            for(Character c : s.toCharArray())// 换成char c 0ms
            {
                if(c == ' ') ans.append("%20");
                else ans.append(c);
            }
            return ans.toString();
        }
    }
    class Solution0ms {
        public String replaceSpace(String s) {
            int length = s.length() * 3;
            char[] str = new char[length];
            int returnStrLength = 0;
            for(int i = 0;i < s.length(); i++){
                if(s.charAt(i) == ' '){
                    str[returnStrLength++] = '%';
                    str[returnStrLength++] = '2';
                    str[returnStrLength++] = '0';
                }else{
                    str[returnStrLength++] = s.charAt(i);
                }
            }
            return new String(str, 0 ,returnStrLength);
        }
    }
    
    
}
