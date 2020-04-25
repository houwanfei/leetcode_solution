package com.hou.leetcode.solution.binary;

public class Search2DMatrix240Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, rigit = rows-1;

        while (left <= rigit) {
            int mid = (left+rigit)/2;
            if (matrix[mid][0] >= target) {
                rigit = mid-1;
            } else {
                left = mid+1;
            }
        }

        int end = left == rows?rows-1:left;
        left = 0;rigit = rows-1;
        while (left <= rigit) {
            int mid = (left+rigit)/2;
            if (matrix[mid][cols-1] >= target) {
                rigit = mid-1;
            } else {
                left = mid+1;
            }
        }
        int begin = rigit == -1? 0: rigit;

        if (matrix[end][0] == target || matrix[begin][cols-1] == target) {
            return true;
        }

        for (int i=begin; i<=end; i++) {
            int ci = 0, cj=cols-1;
                while (ci <= cj) {
                    int cmid = ci + (cj-ci)/2;
                    if (target > matrix[i][cmid]) {
                        ci = cmid+1;
                    } else if (target < matrix[i][cmid]) {
                        cj = cmid-1;
                    } else {
                        return true;
                    }
                }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};

        int[][] matrix = new int[][]{
                {-7, -5, 1, 2}};
        Search2DMatrix240Solution solution = new Search2DMatrix240Solution();
        System.out.println(solution.searchMatrix(matrix, -5));
    }
}
