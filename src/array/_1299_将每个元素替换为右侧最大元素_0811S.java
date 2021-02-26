package array;

/***
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class _1299_将每个元素替换为右侧最大元素_0811S {
    class Solution {
        public int[] replaceElements(int[] arr) {
            int[] brr = new int[arr.length - 1];
            int temp = 0;
            int j = 0;
            for(int i = arr.length - 1; i > 0; i--) {
                if(arr[i] > temp) {
                    temp = arr[i];
                }
                brr[j] = temp;
                j++;
            }
            j = arr.length - 2;
            for(int i = 0; i < arr.length - 1; i++) {
                arr[i] = brr[j];
                j--;
            }
            arr[arr.length - 1] = -1;
            return arr;
        }
    }
    class Solution2 {
        public int[] replaceElements(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            ans[n - 1] = -1;
            for(int i = n - 2; i >= 0; --i) {
                ans[i] = Math.max(ans[i + 1], arr[i + 1]);
            }
            return ans;
        }
    }
}
