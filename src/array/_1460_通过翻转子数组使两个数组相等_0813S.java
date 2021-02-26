package array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * 给你两个长度相同的整数数组 target 和 arr 。
 * 每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 */
public class _1460_通过翻转子数组使两个数组相等_0813S {
    class Solution3ms {
        // 两个数组排序 逐个对比
        public boolean canBeEqual(int[] target, int[] arr) {
            Arrays.sort(target);
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++) {
                if(target[i] != arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    class Solution1ms {
        public boolean canBeEqual(int[] target, int[] arr) {
            // 用桶
            int[] bucket =new int[1001];
            for(int n:target)
                bucket[n]++;
            for(int n:arr){
                if(bucket[n]==0)
                    return false;
                bucket[n]--;
            }
            return true;
        }
    }
    class Solution0ms {
        public boolean canBeEqual(int[] target, int[] arr) {
            if(target.length==1&&target[0]==arr[0]) return true;
            int ans=0;
            int len=target.length;
            for(int i=0;i<len;i++){
                ans=ans^target[i]^arr[i];
            }
            if(ans!=0)return false;
            return true;
        }
    }
}
