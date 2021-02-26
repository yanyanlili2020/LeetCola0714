package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 */
public class _1349_找出数组中的幸运数_0813S {
    class Solution {
        public int findLucky(int[] arr) {
            int[] num = new int[501];
            for(int i = 0; i < arr.length; i++) {
                num[arr[i]]++;
            }
            for(int i = 500; i > 0; i--) {
                if(num[i] == i)
                    return i;
            }
            return -1;
        }
    }
    class Solutionhash慢 {
        public int findLucky(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i : arr)
                map.put(i, map.getOrDefault(i, 0) + 1);
            int res = -1;
            for(int key : map.keySet()) {
                if(key == map.get(key))
                    res = Math.max(res, key);
            }
            return res;
        }
    }
}
