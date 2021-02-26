package array;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/duplicate-zeros/
 */
public class _1089_复写零_0810S {
    class Solution最慢 {
        public void duplicateZeros(int[] arr) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 0) {
                    for(int j = arr.length - 1; j > i; j--) {
                        arr[j] = arr[j - 1];
                    }
                    i++;
                }
            }
        }
    }
    class Solution0ms {
        public void duplicateZeros(int[] arr) {
            int[] temp = Arrays.copyOf(arr, arr.length);
            int index = 0;
            for(int i = 0; i < arr.length; i++) {
                arr[i] = temp[index];
                if(temp[index] == 0 && i < arr.length - 1) {
                    arr[++i] = 0;
                }
                index++;
            }
        }
    }
}
