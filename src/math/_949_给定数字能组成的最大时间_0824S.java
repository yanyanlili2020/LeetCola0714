package math;

/**
 *
 */
public class _949_给定数字能组成的最大时间_0824S {
    class Solution10ms {
        // 暴力
        public String largestTimeFromDigits(int[] A) {
            int ans = -1;
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    if(j != i) {
                        for(int k = 0; k < 4; k++) {
                            if(k != i && k != j) {
                                int l = 6 - i - j - k;
                                int hours = 10 * A[i] + A[j];
                                int mins = 10 * A[k] + A[l];
                                if(hours < 24 && mins < 60)
                                    ans = Math.max(ans, hours * 60 + mins);
                            }
                        }
                    }
                }
            }
            return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
        }
    }
    class Solution0ms {
        // 贪心
        boolean flag;
        public String largestTimeFromDigits(int[] A) {
            String res = helper(A, 2);
            if(!res.isEmpty()) {
                return res;
            }
            return flag ? "" : helper(A, 1);
        }
        private String helper(int[] A, int h0) {
            int[] dic = new int[10];
            for(int n : A) {
                dic[n]++;
            }
            char[] time = new char[5];
            time[2] = ':';
            if((time[0] = findMax(dic, h0)) == 0) {
                flag = true;
                return "";
            }
            if((time[1] = findMax(dic, time[0] == '2' ? 3 : 9)) == 0) {
                return "";
            }
            if((time[3] = findMax(dic, 5)) == 0) {
                return "";
            }
            if((time[4] = findMax(dic, 9)) == 0) {
                return "";
            }
            return String.valueOf(time);
        }
        private char findMax(int[] dic, int ceil) {
            for(int i = ceil; i >= 0; i--) {
                if(dic[i] > 0) {
                    dic[i]--;
                    return (char) (i + '0');
                }
            }
            return 0;
        }
    }
}


