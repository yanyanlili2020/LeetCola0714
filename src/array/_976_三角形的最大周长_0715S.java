package array;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */
public class _976_三角形的最大周长_0715S {
    public int largestPerimeter1(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 3; i >= 0; --i)
            if(A[i] + A[i + 1] > A[i + 2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;
    }
    // 快
    public int largestPerimeter(int[] A) {
        int maxA = getMax(A);
        int maxB = getMax(A);
        int maxC = getMax(A);
        while(maxC > 0) {
            if(maxA < maxB + maxC) {
                return maxA + maxB + maxC;
            } else {
                maxA = maxB;
                maxB = maxC;
                maxC = getMax(A);
            }
        }
        return 0;
    }
    public int getMax(int[] A) {
        int max = 0;
        int maxIndex = -1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        if(maxIndex != -1) {
            A[maxIndex] = 0;
        }
        return max;
    }
}
