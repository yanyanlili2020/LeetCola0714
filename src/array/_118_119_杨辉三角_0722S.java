package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/pascals-triangle
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class _118_119_杨辉三角_0722S {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] temp = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++) {
            List<Integer> List = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) temp[i][j] = 1;
                else temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j];
                List.add(temp[i][j]);
            }
            ans.add(List);
        }
        return ans;
    }
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0) return ans;
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = ans.get(i - 1);
            row.add(1);
            for(int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
    class _119 {
        public List<Integer> getRow(int rowIndex) {
            LinkedList<Integer> ans = new LinkedList<>();
            int[] row = new int[rowIndex + 1];
            Arrays.fill(row, 1);
            for(int i = rowIndex; i > 0; i--) {
                for(int j = 1; j < i; j++) {
                    row[j] = row[j] + row[j - 1];
                }
            }
            for(int i : row) {
                ans.add(i);
            }
            return ans;
        }
    }
}
