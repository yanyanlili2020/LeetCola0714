package hash;

import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons/
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 */
public class _1189_气球的最大数量_0902S {
    class Solutionzx2 {
        public int maxNumberOfBalloons(String text) {
            int[] a = new int[5];
            int ans = 0;
            for(char c : text.toCharArray()) {
                if(c == 'b') a[0]++;
                if(c == 'a') a[1]++;
                if(c == 'l') a[2]++;
                if(c == 'o') a[3]++;
                if(c == 'n') a[4]++;
            }
            while(a[0] > 0 && a[1] > 0 && a[2] > 1 && a[3] > 1 && a[4] > 0) {
                a[0]--;
                a[1]--;
                a[2] -= 2;
                a[3] -= 2;
                a[4]--;
                ans++;
            }
            return ans;
        }
    }
    class Solution1_2 {
        public int maxNumberOfBalloons(String text) {
            int[] tong = new int[26];
            int min = Integer.MAX_VALUE;
            for(int ch : text.toCharArray()) {
                tong[ch - 97]++;// 将字母转化为数字 存入对应桶
            }
            tong['l' - 97] = tong['l' - 97] / 2;// l o 在单词中出现两遍 要除二
            tong['o' - 97] = tong['o' - 97] / 2;
            for(int ch : "balon".toCharArray()) {
                if(tong[ch - 97] < min) {
                    min = tong[ch - 97];
                }
            }
            return min;
        }
    }
    class Solution1 {
        public int maxNumberOfBalloons(String text) {
            int[] tong = new int[26];
            for(char c : text.toCharArray()) {
                tong[c - 'a']++;// 将字母转化为数字 存入对应桶
            }
            int[] balloon = new int[]{tong['b' - 'a'], tong['a' - 'a'],
                    tong['l' - 'a'] >>> 1, tong['l' - 'a'] >>> 1,
                    tong['o' - 'a'] >>> 1, tong['o' - 'a'] >>> 1,
                    tong['n' - 'a']};
            Arrays.sort(balloon);
            return balloon[0];
        }
    }
}
