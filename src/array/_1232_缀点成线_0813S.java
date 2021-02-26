package array;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 */
public class _1232_缀点成线_0813S {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            for(int i = 1; i < coordinates.length - 1; i++) {
                int res1 = (coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i + 1][1] - coordinates[i][1]);
                int res2 = (coordinates[i + 1][0] - coordinates[i][0]) * (coordinates[i][1] - coordinates[i - 1][1]);
                if(res1 != res2) {
                    return false;
                }
            }
            return true;
        }
    }
    class Solution2 {
        public boolean checkStraightLine(int[][] coordinates) {
            int x1 = coordinates[1][0] - coordinates[0][0];
            int y1 = coordinates[1][1] - coordinates[0][1];
            for(int i = 2; i < coordinates.length; i++) {
                int x2 = coordinates[i][0] - coordinates[0][0];
                int y2 = coordinates[i][1] - coordinates[0][1];
                if(x1 * y2 != x2 * y1) {
                    return false;
                }
            }
            return true;
        }
    }
}
