package hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/distribute-candies/
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
 * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 * <p>
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），
 * 直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 */
public class _575_1103_分糖果_0823S {
    class _575 {
        class Solution5ms {
            public int distributeCandies(int[] candies) {
                int half = candies.length >>> 1;
                int typeCount = 0;
                boolean[] array = new boolean[200001];
                for(int candy : candies) {
                    candy += 100000;
                    if(!array[candy]) {
                        array[candy] = true;
                        typeCount++;
                        if(typeCount == half) {
                            return typeCount;
                        }
                    }
                }
                return typeCount;
            }
        }
        public class Solution43ms {
            // 我们可以对给定的 candies 数组进行排序，
            // 并通过比较排序数组的相邻元素来找出唯一的元素。
            // 对于找到的每个新元素（与前一个元素不同），我们需要更新 count。
            // 要返回的值 为 min(count,n/2) 。
            public int distributeCandies(int[] candies) {
                Arrays.sort(candies);
                int count = 1;
                for(int i = 1; i < candies.length && count < candies.length / 2; i++)
                    if(candies[i] > candies[i - 1])
                        count++;
                return count;
            }
        }
        public class Solution44ms {
            //找到唯一元素数量的另一种方法是遍历给定 candies 数组的所有元素，
            // 并继续将元素放入集合中。通过集合的属性，它将只包含唯一的元素。
            // 最后，我们可以计算集合中元素的数量 count。
            // 要返回的值 为 min(count,n/2) 。
            public int distributeCandies(int[] candies) {
                HashSet<Integer> set = new HashSet<>();
                for(int candy : candies) {
                    set.add(candy);
                }
                return Math.min(set.size(), candies.length / 2);
            }
        }
    }
    class _1103 {
        public int[] distributeCandies(int candies, int num_people) {
            int[] ans = new int[num_people];
            int index = 1;
            while(candies > 0) {
                ans[(index - 1) % num_people] += (candies - index > 0 ? index : candies);
                candies = candies - index;
                index++;
            }
            return ans;
        }
    }
}
