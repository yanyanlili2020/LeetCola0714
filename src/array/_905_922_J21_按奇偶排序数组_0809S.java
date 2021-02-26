package array;

/***
 * https://leetcode-cn.com/problems/sort-array-by-parity/ 905
 * 先偶后奇
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/ 922
 * 奇偶交错
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 先奇后偶
 */
public class _905_922_J21_按奇偶排序数组_0809S {
    class Solution905 {
        public int[] sortArrayByParity(int[] A) {
            int[] ans = new int[A.length];
            int t = 0;
            for(int i = 0; i < A.length; ++i)
                if(A[i] % 2 == 0) {
                    ans[t++] = A[i];
                }
            for(int i = 0; i < A.length; ++i)
                if(A[i] % 2 == 1) {
                    ans[t++] = A[i];
                }
            return ans;
        }
    }
    class Solution922 {
        public int[] sortArrayByParityII(int[] A) {
            int j = 0;
            for(int i = 1; i < A.length; i = i + 2) {
                if(A[i] % 2 == 0) {
                    while(A[j] % 2 == 0) {
                        j = j + 2;
                    }
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
            return A;
        }
    }
    class SolutionJ21 {
        // 905 的方法用在这道题 慢
        public int[] exchange(int[] nums) {
            for(int i = 0, j = nums.length - 1; i < j; ) {
                while((nums[i] & 1) != 0 && i < j) {
                    i++;
                }
                while((nums[j] & 1) == 0 && i < j) {
                    j--;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            return nums;
        }
    }
}

