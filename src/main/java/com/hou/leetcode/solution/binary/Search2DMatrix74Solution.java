package com.hou.leetcode.solution.binary;

/**
 * @Description 思路：二分查找
 * @auther houwf
 * @create 2019-12-16 13:55
 */
public class Search2DMatrix74Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0, hi = row-1;

        while (low <= hi) {
            int mid = (low + hi) / 2;
            if (matrix[mid][0] <= target && matrix[mid][col -1] >= target) {
                //在这一行中
                int low2 = 0, hi2 = col-1;
                while (low2 <= hi2) {
                    int mid2 = (low2 + hi2) / 2;
                    if (matrix[mid][mid2] < target) {
                        low2 = mid2 + 1;
                    } else if (matrix[mid][mid2] > target) {
                        hi2 = mid2 - 1;
                    } else {
                        return true;
                    }
                }
                return false;
            } else if (matrix[mid][0] > target) {
                hi = mid -1;
            } else if (matrix[mid][col-1] < target) {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix74Solution solution = new Search2DMatrix74Solution();
        int[][] matrix2 = new int[][]{{1}};
//        int[][] matrix = new int[][] {{1,   3,  5,  7},{10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(matrix2, 1));
    }
}
