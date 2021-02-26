package array;

/**
 * https://leetcode-cn.com/problems/play-with-chips/
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 */
public class _1217_玩筹码_0813S {
    class Solution {
//        遍历一次数组，找到其中有多少个奇数和偶数位置的筹码，取其中比较少的
        public int minCostToMoveChips(int[] chips) {
            int odd = 0, even = 0;
            for(int i = 0; i < chips.length; i++) {
                if(chips[i] % 2 == 0) {
                    even++;
                } else if(chips[i] % 2 != 0) {
                    odd++;
                }
            }
            return Math.min(even, odd);
        }
    }
}
