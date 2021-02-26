package string;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class _125_验证回文串_0823S {
    class Solution6ms {
        // 反转字符串 和原字符串对比 相同则为回文串
        public boolean isPalindrome(String s) {
            StringBuffer sgood = new StringBuffer();
            int length = s.length();
            for(int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if(Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }
            StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
            return sgood.toString().equals(sgood_rev.toString());
        }
    }
    class Solution6ms2 {
        public boolean isPalindrome(String s) {
            StringBuffer sgood = new StringBuffer();
            int length = s.length();
            for(int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if(Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }
            int n = sgood.length();
            int left = 0, right = n - 1;
            while(left < right) {
                if(Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
            return true;
        }
    }
    class Solution2ms {
        public boolean isPalindrome(String s) {
            if(s == null || s.length() == 0) {
                return true;
            }
            int n = s.length();
            int i = 0, j = n - 1;
            while(i <= j) {
                while(i <= j && !validChar(s.charAt(i))) {
                    i++;
                }
                while(i <= j && !validChar(s.charAt(j))) {
                    j--;
                }
                if(i <= j) {
                    if(!compare(s.charAt(i), s.charAt(j))) {
                        return false;
                    }
                    else {
                        i++;
                        j--;
                    }
                }
            }
            return true;
        }
        private boolean validChar(char x) {
            return ('Z' - x >= 0 && 'Z' - x <= 25) || ('z' - x >= 0 && 'z' - x <= 25)
                    || ('9' - x >= 0 && '9' - x <= 9);
        }
        private boolean compare(char x, char y) {
            int gap = 'Z' - 'z';
            return (x == y || (!('9' - x >= 0 && '9' - x <= 9) && (x - y == gap || y - x == gap)));
        }
    }
}
