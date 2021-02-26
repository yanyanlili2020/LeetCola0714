package array;

/***
 * https://leetcode-cn.com/problems/third-maximum-number/
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/ 乘积 1464
 */
public class _414_628_第三大的数_三个数的最大乘积_0810S {
    class Solution414 {
        public int thirdMax(int[] nums) {
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.max(nums[0], nums[1]);
            int max1 = Integer.MIN_VALUE;// -2147483648
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;
            int flag = 0;
            boolean f = true;
            for(int n : nums) {
                if(n == Integer.MIN_VALUE && f) {
                    flag++;
                    f = false;
                }
                if(n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                    flag++;
                } else if(n > max2 && n < max1) {
                    max3 = max2;
                    max2 = n;
                    flag++;
                } else if(n > max3 && n < max2) {
                    max3 = n;
                    flag++;
                }
            }
            return flag >= 3 ? max3 : max1;
        }
    }
    public class Solution628 {
        public int maximumProduct(int[] nums) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            for(int n : nums) {
                if(n <= min1) {
                    min2 = min1;
                    min1 = n;
                } else if(n <= min2) {     // n lies between min1 and min2
                    min2 = n;
                }
                if(n >= max1) {            // n is greater than max1, max2 and max3
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                } else if(n >= max2) {     // n lies betweeen max1 and max2
                    max3 = max2;
                    max2 = n;
                } else if(n >= max3) {     // n lies betwen max2 and max3
                    max3 = n;
                }
            }
            return Math.max(min1 * min2 * max1, max1 * max2 * max3);
        }
    }
}
