package bit;

/**
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
 * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
public class _1342_将数字变成0的操作次数_0827SO {
    class Solutionzx {
        public int numberOfSteps(int num) {
            int cnt = 0;
            while(num != 0) {
                num = (num % 2 == 0) ? num / 2 : num - 1;// num >> 1 : num & -2;
                cnt++;
            }
            return cnt;
        }
    }
    class Solutiondigui {
        private int count = 0;
        public int numberOfSteps(int num) {
            if(num != 0) {
                count++;
                if((num & 1) != 0) {
                    numberOfSteps(num & -2);
                }
                else {
                    numberOfSteps(num >> 1);
                }
            }
            return count;
        }
    }
}
