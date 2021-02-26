package array;

/***
 * https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class _136_389_只出现一次的数字_0809S {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums) ans ^= n;
        return ans;
    }
    class _389_字符串找不同 {
        class Solution {
            public char findTheDifference(String s, String t) {
                char ans = 0;
                for(char c : s.toCharArray()) ans ^= c;
                for(char c : t.toCharArray()) ans ^= c;
                return ans;
            }
        }
        class Solution2 {
            public char findTheDifference(String s, String t) {
                return (char) (Math.abs(sumChar(s) - sumChar(t)));
            }
            //把char转成数字求和
            public int sumChar(String str) {
                int sum = 0;
                for(char c : str.toCharArray()) sum += c;
                return sum;
            }
        }
    }
}