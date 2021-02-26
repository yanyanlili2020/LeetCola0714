package math;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 */
public class _1512_好数对的数目_0724S {
	class 哈希 {
		public int numIdenticalPairs(int[] nums) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int num : nums) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}

			int ans = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int v = entry.getValue();
				ans += v * (v - 1) / 2;
			}

			return ans;
		}
	}
	class 快 {
		public int numIdenticalPairs(int[] nums) {
			int[] temp = new int[100];
			int a = 0;
			for (int num : nums) {
				a += temp[num - 1]++;
			}
			return a;
		}
	}
	class 暴力 {
		public int numIdenticalPairs(int[] nums) {
			int ans = 0;
			for (int i = 0; i < nums.length; ++i) {
				for (int j = i + 1; j < nums.length; ++j) {
					if (nums[i] == nums[j]) {
						++ans;
					}
				}
			}
			return ans;
		}
	}
}
