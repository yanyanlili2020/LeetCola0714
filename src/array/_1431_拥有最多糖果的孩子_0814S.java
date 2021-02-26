package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class _1431_拥有最多糖果的孩子_0814S {
    class Solution {
        // 开始用了数组 和返回值不一样报错 返回值要求 装布尔值的list
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int n = candies.length;
            int maxCandies = 0;
            for(int i = 0; i < n; ++i) {
                maxCandies = Math.max(maxCandies, candies[i]);
            }
            List<Boolean> ret = new ArrayList<Boolean>();
            for(int i = 0; i < n; ++i) {
                ret.add(candies[i] + extraCandies >= maxCandies);
            }
            return ret;
        }
    }
}
