package math;

/***
 * https://leetcode-cn.com/problems/airplane-seat-assignment-probability/
 */
public class _1227_飞机座位分配概率_0724M {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1;
        return 0.5;
    }
}
