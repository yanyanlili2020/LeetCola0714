package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
 */
public class _1346_检查整数及其两倍数是否存在_0813S {
    class Solution3ms {
        public boolean checkIfExist(int[] arr) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }
            for(int n = 0; n < arr.length; n++) {
                if(map.containsKey(arr[n] * 2) && map.get(arr[n] * 2) != n) {
                    return true;
                }
            }
            return false;
        }
    }
    class Solution0ms {
        public boolean checkIfExist(int[] arr) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] % 2 == 0) {
                    int a = arr[i] / 2;
                    if(check(arr, a, i) == true) {
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean check(int[] arr, int x, int index) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == x && index != i) {
                    return true;
                }
            }
            return false;
        }
    }
    class Solution1ms {
        public boolean checkIfExist(int[] arr) {
            // Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++) {
                int num = arr[i] * 2;
                for(int j = 0; j < arr.length; j++) {
                    if(num == arr[j] && i != j) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
