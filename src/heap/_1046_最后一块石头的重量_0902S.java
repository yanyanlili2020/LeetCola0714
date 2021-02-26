package heap;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/last-stone-weight
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
 * 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *     如果 x == y，那么两块石头都会被完全粉碎；
 *     如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class _1046_最后一块石头的重量_0902S {
    class Solution1 {
        public int lastStoneWeight(int[] stones) {
            if (stones.length == 1) {
                return stones[0];
            }
            Arrays.sort(stones);
            while (stones[stones.length - 2] != 0) {
                stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
                stones[stones.length - 2] = 0;
                Arrays.sort(stones);
            }
            return stones[stones.length - 1];
        }
    }
    class Solution0 {
        public int lastStoneWeight(int[] stones) {
            int end = stones.length - 1;
            int k = 0;
            while( k != stones.length && k != stones.length - 1 ){
                Arrays.sort(stones);
                int x = stones[end - 1];
                int y = stones[end];
                if( x == y ){
                    stones[end - 1] = stones[end] = 0;
                    k += 2;
                }else{
                    stones[end - 1] = stones[end] - stones[end - 1];
                    stones[end] = -1;
                    k += 1;
                }
            }
            Arrays.sort(stones);
            return stones[end];
        }
    }
    
}
