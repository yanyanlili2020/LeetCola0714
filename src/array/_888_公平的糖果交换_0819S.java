package array;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class _888_公平的糖果交换_0819S {
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            boolean[] set = new boolean[100001];
            int num = 0;
            for (int i : A) {
                set[i] = true;
                num += i;
            }
            for (int i : B) {
                num -= i;
            }
            num /= 2;
            for (int i : B) {
                int tmp = i + num;
                if (tmp > 0 && tmp < 100001 && set[tmp])
                    return new int[]{tmp, i};
            }
            return null;
        }
    }
}
