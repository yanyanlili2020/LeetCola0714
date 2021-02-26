package math;

import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/triangle/
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class _120_三角形最小路径和_0714M {
    // solution1 2ms
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
    // solution2 1ms
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) return 0;
        int[] record = new int[len+1];
        Arrays.fill(record, Integer.MAX_VALUE); record[1] = 0;
        for (int i=0; i < len; i++)
            upDate(record, triangle.get(i));
        int result = record[1];
        for (int i=2; i <= len; i++)
            result = Math.min(result, record[i]);
        return result;
    }
    private void upDate(int[] record, List<Integer> row) {
        int len = row.size();
        for (int i = len; i > 0; i--)
            record[i] = row.get(i-1) + Math.min(record[i], record[i-1]);
    }
}
