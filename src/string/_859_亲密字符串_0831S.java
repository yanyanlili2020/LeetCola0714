package string;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 * 给定两个由小写字母构成的字符串 A 和 B ，
 * 只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 * 就返回 true ；否则返回 false 。
 */
public class _859_亲密字符串_0831S {
    class Solution1 {
        public boolean buddyStrings(String A, String B) {
            int lenA = A.length();
            int lenB = B.length();
            //如果俩字符串长度不同，或者字符串长度小于2
            if(lenA != lenB || lenA < 2 || lenB < 2)
                return false;
            //如果俩字符串相同，并且存在重复字符，返回true
            if(A.equals(B)) {
                HashSet<Character> set = new HashSet<>();
                for(int i = 0; i < lenA; i++) {
                    if(set.contains(A.charAt(i)))
                        return true;
                    else
                        set.add(A.charAt(i));
                }
                return false;
            }
            //如果俩字符串不同，进行判断
            int count = 0;    //计数不同的字符个数
            int pre = -1, post = -1;  //pre，post分别记录俩不同字符的位置
            for(int i = 0; i < lenA; i++) {
                if(count > 2) {
                    return false;
                }
                if(A.charAt(i) == B.charAt(i))
                    continue;
                else {
                    ++count;
                    if(pre == -1)
                        pre = i;
                    else
                        post = i;
                }
            }
            return count == 2 && A.charAt(pre) == B.charAt(post) && A.charAt(post) == B.charAt(pre);
        }
    }
    class Solution3 {
        public boolean buddyStrings(String A, String B) {
            if(A.length() != B.length()) return false;
            if(A.equals(B)) {
                int[] count = new int[26];
                for(int i = 0; i < A.length(); ++i)
                    count[A.charAt(i) - 'a']++;
                for(int c : count)
                    if(c > 1) return true;
                return false;
            }
            else {
                int first = -1, second = -1;
                for(int i = 0; i < A.length(); ++i) {
                    if(A.charAt(i) != B.charAt(i)) {
                        if(first == -1)
                            first = i;
                        else if(second == -1)
                            second = i;
                        else
                            return false;
                    }
                }
                return (second != -1 && A.charAt(first) == B.charAt(second) &&
                        A.charAt(second) == B.charAt(first));
            }
        }
    }
}
