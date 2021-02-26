package math;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 约瑟夫环
 */
public class _J62_圆圈中最后剩下的数字_0823S {
    class Solution4ms {
        public int lastRemaining(int n, int m) {
            int dp1 = 1;
            for(int i = 2; i <= n; i++) {
                int removeNum = m % i;
                //剩下的要留下来的
                dp1 = removeNum + dp1;
                if(dp1 > i) {
                    dp1 = dp1 - i;
                }
            }
            return dp1 - 1;
        }
    }
    class Solution7ms {
        public int lastRemaining(int n, int m) {
            int f = 0;
            for(int i = 2; i <= n; i++) {
                f = (f + m) % i;
            }
            return f;
        }
    }
    class Solution1062ms {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while(n > 1) {
                idx = (idx + m - 1) % n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }
    }
}
