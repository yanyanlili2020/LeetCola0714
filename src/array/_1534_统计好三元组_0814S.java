package array;

/**
 * https://leetcode-cn.com/problems/count-good-triplets/
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *     0 <= i < j < k < arr.length
 *     |arr[i] - arr[j]| <= a
 *     |arr[j] - arr[k]| <= b
 *     |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 * 返回 好三元组的数量 。
 */
public class _1534_统计好三元组_0814S {
    class Solution89ms {
        // 自己写的 超级无敌慢
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int cnt=0;
            for(int i = 0; i < arr.length; ++i){
                for(int j = 1; j < arr.length; ++j){
                    for(int k = 2; k < arr.length; ++k){
                        if((Math.abs(arr[i] - arr[j]) <= a)
                                &&(Math.abs(arr[j] - arr[k]) <= b)
                                &&(Math.abs(arr[i] - arr[k]) <= c)
                                &&(i < j )&&(j < k)){
                            cnt++;}
                    }
                }
            }
            
            return cnt;
        }
    }
    class Solution18ms {
        // 修改 j k 的初始值
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int cnt=0;
            for(int i = 0; i < arr.length; ++i){
                for(int j = i+1; j < arr.length; ++j){
                    for(int k = j+1; k < arr.length; ++k){
                        if((Math.abs(arr[i] - arr[j]) <= a)
                                &&(Math.abs(arr[j] - arr[k]) <= b)
                                &&(Math.abs(arr[i] - arr[k]) <= c)
                        ){
                            cnt++;}
                    }
                }
            }
            
            return cnt;
        }
    }
}
