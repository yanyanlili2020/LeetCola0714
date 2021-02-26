package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference/
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 */
public class _1200_最小绝对差_0823S {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            return new java.util.AbstractList<List<Integer>>() {
                int[] buffer;
                int size;
                int min;
                boolean init;
                private void init() {
                    Arrays.sort(arr);
                    buffer = new int[arr.length];
                    min = Integer.MAX_VALUE;
                    for(int i = 1; i < arr.length; i++) {
                        int dif = arr[i] - arr[i - 1];
                        if(dif > min) {
                            continue;
                        }
                        if(dif < min) {
                            size = 0;
                            min = dif;
                        }
                        buffer[size++] = arr[i];
                    }
                    init = true;
                }
                // 缺少范围检查
                @Override
                public List<Integer> get(int index) {
                    if(!init) {
                        init();
                    }
                    return Arrays.asList(buffer[index] - min, buffer[index]);
                }
                @Override
                public int size() {
                    if(!init) {
                        init();
                    }
                    return size;
                }
            };
        }
    }
    class Solution18ms {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> res = new LinkedList<>();
            int min = 100000;
            for(int i = 1; i < arr.length; i++) {
                int tmp = arr[i] - arr[i - 1];
                // 找到新的最小差，清空原有结果
                if(tmp < min) {
                    min = tmp;
                    res.clear();
                }
                // 如果是最小差，记录
                if(tmp == min) {
                    List<Integer> item = new ArrayList<>(2);
                    item.add(arr[i - 1]);
                    item.add(arr[i]);
                    res.add(item);
                }
            }
            return res;
        }
    }
}
