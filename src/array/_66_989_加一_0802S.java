package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/plus-one/
 */
public class _66_989_加一_0802S {
    class Solution {
        public int[] plusOne(int[] digits) {
            for(int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if(digits[i] != 0) return digits;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
    class _989_数组形式的整数加法 {
        class Solution {
            public List<Integer> addToArrayForm(int[] A, int K) {
                int N = A.length;
                int cur = K;
                List<Integer> ans = new ArrayList();
                int i = N;
                while(--i >= 0 || cur > 0) {
                    if(i >= 0)
                        cur += A[i];
                    ans.add(cur % 10);
                    cur /= 10;
                }
                Collections.reverse(ans);
                return ans;
            }
        }
        class Solution2 {
            public List<Integer> addToArrayForm(int[] A, int K) {
                int pos = A.length - 1;
                while(K > 0 && pos >= 0) {
                    K += A[pos];
                    A[pos] = K % 10;
                    pos--;
                    K = K / 10;
                }
                List<Integer> list = new ArrayList<>();
                while(K > 0) {
                    list.add(K % 10);
                    K /= 10;
                }
                List<Integer> ans = new ArrayList<>();
                while(!list.isEmpty()) ans.add(list.remove(list.size() - 1)); //注意区分get方法和remove方法的区别，前者不删节点，后者删节点
                for(int i = 0; i < A.length; i++) ans.add(A[i]);
                return ans;
            }
        }
    }
}
