package array;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class _m0101_判定字符是否唯一_0830S {
    class Solutionzx {
        public boolean isUnique(String astr) {
            int len=astr.length();
            int[] tong = new int[123];
            for(int i=0;i<len;i++){
                tong[astr.charAt(i)]++;
            }
            for(int i=97;i<123;i++){
                if(tong[i]>1)
                    return false;
            }
            return true;
        }
    }
    class Solution {
        public boolean isUnique(String astr) {
            for(int i=0;i<astr.length();i++){
                if(astr.indexOf(astr.charAt(i)) !=astr.lastIndexOf(astr.charAt(i))){
                    return false;
                }
            }
            return true;
        }
    }
}
