package com.hou.leetcode.solution;

public class UniquePathsII63Solution {
    public int solution(int[][] grid){
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    path[i][j] = 0;
                } else {
                    if (i == 0 && j == 0){
                        path[i][j] = 1;
                    } else if (i == 0){
                        path[i][j] = path[i][j-1];
                    }else if (j == 0){
                        path[i][j] = path[i-1][j];
                    } else {
                        path[i][j] = path[i][j-1] + path[i-1][j];
                    }
                }
            }
        }

        return path[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
        int[][] grid = {{1, 0}};
        UniquePathsII63Solution solution = new UniquePathsII63Solution();
        System.out.println(solution.solution(grid));
    }
}
