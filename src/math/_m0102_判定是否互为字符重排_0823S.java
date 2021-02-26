package math;

/**
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class _m0102_判定是否互为字符重排_0823S {
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if(s1.length() != s2.length()) return false;
            int[] nums = new int[26];
            int len = s1.length();
            for(int i = 0; i < len; i++) {
                nums[s1.charAt(i) - 97]++;
                nums[s2.charAt(i) - 97]--;
            }
            for(int num : nums) {
                if(num != 0) return false;
            }
            return true;
        }
    }
    class Solution2 {
        public boolean CheckPermutation(String s1, String s2) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            boolean temp = true;
            for(int i1 = 0; i1 < c1.length; i1++) {
                for(int i2 = 0; i2 < c2.length; i2++) {
                    if(c2[i2] == c1[i1]) {
                        c2[i2] = '+';
                        break;
                    }
                }
            }
            for(int i = 0; i < c2.length; i++) {
                if(c2[i] == '+')
                    temp = true;
                else {
                    temp = false;
                    break;
                }
            }
            return temp;
        }
    }
}
