package array;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
 */
public class _448_找到所有数组中消失的数字_0810 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            boolean[] map = new boolean[n + 1];
            for(int x : nums) map[x] = true;
            List<Integer> ans = new ArrayList<>(n);
            for(int i = 1; i <= n; i++) if(!map[i]) ans.add(i);
            return ans;
        }
    }
    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                int n = Math.abs(nums[i]) - 1;
                if(nums[n] > 0) nums[n] = -nums[n];
            }
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < nums.length; i++)
                if(nums[i] > 0) ans.add(i + 1);
            return ans;
        }
    }
}
