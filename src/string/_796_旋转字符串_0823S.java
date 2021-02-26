package string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-string/
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。
 * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea'。
 * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
 */
public class _796_旋转字符串_0823S {
    class Solution0ms {
        public boolean rotateString(String A, String B) {
            if(A.length() != B.length()) {
                return false;
            }
            StringBuilder sb = new StringBuilder(A);
            sb.append(A);
            return sb.indexOf(B) > -1;
        }
    }
    class Solution1ms {
        // 自写的 暴力 逐个对比
        public boolean rotateString(String A, String B) {
            if(A.length() != B.length()) {
                return false;
            }
            if(A.length() == 0) {
                return true;
            }
            for(int i = 0; i < A.length(); i++) {
                if(A.equals(B.substring(i, B.length()) + B.substring(0, i))) {
                    return true;
                }
            }
            return false;
        }
    }
    class Solution0ms2 {
        // 穷举
        public boolean rotateString(String A, String B) {
            if(A.length() != B.length()) {
                return false;
            }
            if(A.length() == 0) {
                return true;
            }
            search:
            for(int s = 0; s < A.length(); ++s) {
                for(int i = 0; i < A.length(); ++i) {
                    if(A.charAt((s + i) % A.length()) != B.charAt(i)) {
                        continue search;
                    }
                }
                return true;
            }
            return false;
        }
    }
    class Solution0ms3 {
        //  A + A 包含了所有可以通过旋转操作从 A 得到的字符串，因此我们只需要判断 B 是否为 A + A 的子串即可。
        public boolean rotateString(String A, String B) {
            return A.length() == B.length() && (A + A).contains(B);
        }
    }
    class Solution1ms2 {
        // KMP
        public boolean rotateString(String A, String B) {
            int N = A.length();
            if(N != B.length()) return false;
            if(N == 0) return true;
            //Compute shift table
            int[] shifts = new int[N + 1];
            Arrays.fill(shifts, 1);
            int left = -1;
            for(int right = 0; right < N; ++right) {
                while(left >= 0 && (B.charAt(left) != B.charAt(right)))
                    left -= shifts[left];
                shifts[right + 1] = right - left++;
            }
            //Find match of B in A+A
            int matchLen = 0;
            for(char c : (A + A).toCharArray()) {
                while(matchLen >= 0 && B.charAt(matchLen) != c)
                    matchLen -= shifts[matchLen];
                if(++matchLen == N) return true;
            }
            return false;
        }
    }
}
