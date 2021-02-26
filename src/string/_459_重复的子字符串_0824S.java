package string;

/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class _459_重复的子字符串_0824S {
    class Solution0ms {
        public boolean repeatedSubstringPattern(String s) {
            int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
            int l = s.length();
            for (int i : primes) {
                if (i > l) break;
                if (l % i == 0) {
                    boolean flag = true;
                    int j = l / i;
                    for (int n = l; n > j; n -= j) {
                        if (!s.substring(n - j, n).equals(s.substring(n - 2 * j, n - j))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    class Solution2ms {
        public boolean repeatedSubstringPattern(String s) {
            if(s == null || s.length() < 2) {
                return false;
            }
            int n = s.length();
            for(int i = n / 2; i >= 1; i--) {
                if(n % i == 0) {
                    boolean flag = true;
                    for(int j = n / i; j > 0; j--) {
                        if(!s.substring(0, i).equals(s.substring(i * (j - 1), i * j))) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    class Solution12ms {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for(int i = 1; i * 2 <= n; ++i) {
                if(n % i == 0) {
                    boolean flag = true;
                    for(int j = i; j < n; ++j) {
                        if(s.charAt(j) != s.charAt(j - i)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    class Solution95ms {
        //
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).indexOf(s, 1) != s.length();
        }
    }
    
    
}
