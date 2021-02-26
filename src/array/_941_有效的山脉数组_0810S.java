package array;

/***
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
public class _941_有效的山脉数组_0810S {
    class Solution慢 {
        public boolean validMountainArray(int[] A) {
            int N = A.length;
            int i = 0;
            while(i + 1 < N && A[i] < A[i + 1]) i++;
            if(i == 0 || i == N - 1) return false;
            while(i + 1 < N && A[i] > A[i + 1]) i++;
            return i == N - 1;
        }
    }
    class Solution2 {
        public boolean validMountainArray(int[] A) {
            if(A.length <= 1) return false;
            int right = A.length - 1;
            int left = 0;
            while(A[right - 1] > A[right] && right - 1 > 0) right--;
            while(A[left] < A[left + 1] && left + 1 < A.length - 1) left++;
            return left == right;
        }
    }
}
