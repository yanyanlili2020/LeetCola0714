package array;

/**
 * https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 */
public class _1010_总持续时间可被60整除的歌曲_0813S {
    class Solution2 {
        public int numPairsDivisibleBy60(int[] time) {
            int length = 0;
            int[] temp = new int[60];
            for(int num : time) {
                temp[num % 60]++;
            }
//        求余为0的组合
            length += temp[0] * (temp[0] - 1) / 2;
//        求余为30的组合
            length += temp[30] * (temp[30] - 1) / 2;
//        其他的组合
            for(int i = 1; i < 30; i++) {
                length += temp[i] * temp[60 - i];
            }
            return length;
        }
    }
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int count = 0;
            int[] seconds = new int[60];
            for(int t : time) {
                seconds[t % 60] += 1;
            }
            count += combination(seconds[30], 2);
            count += combination(seconds[0], 2);
            int i = 1, j = 59;
            while(i < j) {
                count += seconds[i++] * seconds[j--];
            }
            return count;
        }
        // 求组合数
        public int combination(int n, int k) {
            long result = 1;
            for(int i = 1; i <= k; i++) {
                result = result * (n - i + 1) / i;
            }
            return (int) result;
        }
    }
}
