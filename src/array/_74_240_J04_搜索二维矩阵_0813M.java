package array;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class _74_240_J04_搜索二维矩阵_0813M {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 从左下角开始查找
            int row = matrix.length - 1;
            int col = 0;
            while(row >= 0 && col < matrix[0].length) {
                if(matrix[row][col] > target) {
                    row--;
                } else if(matrix[row][col] < target) {
                    col++;
                } else { // found it
                    return true;
                }
            }
            return false;
        }
    }
    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if(m == 0) {
                return false;
            }
            int n = matrix[0].length;
            // 二分查找
            int left = 0, right = m * n - 1;
            int pivot, pivotElement;
            while(left <= right) {
                pivot = (left + right) / 2;
                pivotElement = matrix[pivot / n][pivot % n];
                if(target == pivotElement) {
                    return true;
                } else {
                    if(target < pivotElement) right = pivot - 1;
                    else left = pivot + 1;
                }
            }
            return false;
        }
    }
}
