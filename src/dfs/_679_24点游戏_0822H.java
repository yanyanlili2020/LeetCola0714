package dfs;

/**
 * https://leetcode-cn.com/problems/24-game/
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 */
@SuppressWarnings("unused")
public class _679_24点游戏_0822H {
    class Solution0 {
        public boolean judgePoint24(int[] nums) {
            double a = nums[0];
            double b = nums[1];
            double c = nums[2];
            double d = nums[3];
            return judge(a, b, c, d);
        }
        public boolean judge(double a, double b, double c, double d) {
            return
                    // a b
                    judge(a + b, c, d) ||
                            judge(a * b, c, d) ||
                            judge(a - b, c, d) ||
                            judge(b - a, c, d) ||
                            judge(a / b, c, d) ||
                            judge(b / a, c, d) ||
                            // b c
                            judge(c + b, a, d) ||
                            judge(c * b, a, d) ||
                            judge(c - b, a, d) ||
                            judge(b - c, a, d) ||
                            judge(c / b, a, d) ||
                            judge(b / c, a, d) ||
                            // c d
                            judge(c + d, a, b) ||
                            judge(c * d, a, b) ||
                            judge(c - d, a, b) ||
                            judge(d - c, a, b) ||
                            judge(c / d, a, b) ||
                            judge(d / c, a, b) ||
                            // b d
                            judge(b + d, a, c) ||
                            judge(b * d, a, c) ||
                            judge(b - d, a, c) ||
                            judge(d - b, a, c) ||
                            judge(b / d, a, c) ||
                            judge(d / b, a, c) ||
                            // a c
                            judge(a + c, b, d) ||
                            judge(a * c, b, d) ||
                            judge(a - c, b, d) ||
                            judge(c - a, b, d) ||
                            judge(a / c, b, d) ||
                            judge(c / a, b, d) ||
                            // a d
                            judge(a + d, b, c) ||
                            judge(a * d, b, c) ||
                            judge(a - d, b, c) ||
                            judge(d - a, b, c) ||
                            judge(a / d, b, c) ||
                            judge(d / a, b, c);
        }
        public boolean judge(double a, double b, double c) {// 24 , 3 , 8
            return
                    // a b
                    judge(a + b, c) ||
                            judge(a * b, c) ||
                            judge(a - b, c) ||
                            judge(b - a, c) ||
                            judge(a / b, c) ||
                            judge(b / a, c) ||
                            // b c
                            judge(c + b, a) ||
                            judge(c * b, a) ||
                            judge(c - b, a) ||
                            judge(b - c, a) ||
                            judge(c / b, a) ||
                            judge(b / c, a) ||
                            // a c
                            judge(c + a, b) ||
                            judge(c * a, b) ||
                            judge(c - a, b) ||
                            judge(a - c, b) ||
                            judge(c / a, b) ||
                            judge(a / c, b);
        }
        public boolean judge(double a, double b) {
            return
                    //注意精度
                    Math.abs(a + b - 24) < 0.001 ||
                            Math.abs(a - b - 24) < 0.001 ||
                            Math.abs(b - a - 24) < 0.001 ||
                            Math.abs(a * b - 24) < 0.001 ||
                            Math.abs(a / b - 24) < 0.001 ||
                            Math.abs(b / a - 24) < 0.001;
        }
    }
    class Solution1 {
        public boolean judgePoint24(int[] nums) {
            return backTrack(nums, 0);
        }
        // 第一步：求出所有排列，一一验证
        public boolean backTrack(int[] nums, int index) {
            if(index == 4) {
                return judge(nums[0], nums[1], nums[2], nums[3]);
            }
            for(int i = index; i < 4; i++) {
                swap(nums, index, i);
                if(backTrack(nums, index + 1)) return true;
                swap(nums, index, i);
            }
            return false;
        }
        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        // 第二步：由于已经全排列，a、b、c、d 都是等价的，利用四种运算符选出三个数继续
        public boolean judge(double a, double b, double c, double d) {
            return judge(a + b, c, d) ||
                    judge(a - b, c, d) ||
                    judge(a * b, c, d) ||
                    judge(a / b, c, d);
        }
        // 第三步：a 是有两个数组成的，b、c 只表示一个数，等价
        public boolean judge(double a, double b, double c) {
            // 情况一：a 和 b(c) 组合，a 和 b(c) 不等价，- 号和 / 号需要考虑两种情况
            return judge(a + b, c) ||
                    judge(a - b, c) ||
                    judge(a * b, c) ||
                    judge(a / b, c) ||
                    judge(b - a, c) ||
                    judge(b / a, c) ||
                    // 情况二：b 和 c 组合
                    judge(a, b - c) ||
                    judge(a, b + c) ||
                    judge(a, b * c) ||
                    judge(a, b / c);
        }
        // 第四步：a 和 b 不等价
        public boolean judge(double a, double b) {
            return Math.abs(a + b - 24) < 0.001 ||
                    Math.abs(a - b - 24) < 0.001 ||
                    Math.abs(a * b - 24) < 0.001 ||
                    Math.abs(a / b - 24) < 0.001 ||
                    Math.abs(b - a - 24) < 0.001 ||
                    Math.abs(b / a - 24) < 0.001;
        }
    }
}
