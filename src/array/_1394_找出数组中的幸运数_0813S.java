package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *     如果数组中存在多个幸运数，只需返回 最大 的那个。
 *     如果数组中不含幸运数，则返回 -1 。
 */
public class _1394_找出数组中的幸运数_0813S {
    class Solution{
        public int findLucky(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i : arr)
                map.put(i, map.getOrDefault(i, 0) + 1);
            int res = -1;
            for(int key : map.keySet()){
                if(key == map.get(key))
                    res = Math.max(res, key);
            }
            return res;
        }
    }
}
