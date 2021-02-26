package LCP;

/**
 *
 */
public class _06_拿硬币_0828S {
    class Solutionzx {
        public int minCount(int[] coins) {
            int cnt=0;
            for(int n:coins){
                while(n!=0){
                    if(n==1){
                        cnt++;
                        n--;}
                    else {
                        n=n-2;
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
    class Solution {
        public int minCount(int[] coins) {
            int n = 0;
            for(int i = 0; i < coins.length; i++){
                n += (coins[i] + 1)/2;
            }
            return n;
        }
    }
}
