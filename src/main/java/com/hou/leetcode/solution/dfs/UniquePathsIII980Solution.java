package com.hou.leetcode.solution.dfs;

public class UniquePathsIII980Solution {
    int path = 0;
    int count = 0;
    public int uniquePathsIII(int[][] grid) {
        int srow=0,scol=0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    srow=i;
                    scol=j;
                } else if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        dfs(grid, new boolean[grid.length][grid[0].length], srow, scol, 0);
        return path;
    }

    private void dfs(int[][] grid, boolean[][] used, int i, int j, int num) {
        if (grid[i][j] == 2) {
            if (num-1 == count) {
                path++;
                return;
            }
            return;
        }
        int[][] directions = new int[][]{{-1,0}, {0,1}, {1, 0}, {0, -1}};
        for (int[] direction : directions) {
            if (check(grid, used, i+direction[0], j+direction[1])) {
                used[i+direction[0]][j+direction[1]] = true;
                dfs(grid, used, i+direction[0], j+direction[1], num+1);
                used[i+direction[0]][j+direction[1]] = false;
            }
        }
    }

    private boolean check(int[][] grid, boolean[][] used, int i, int j) {
        if (i>=0 && i<grid.length && j>=0 && j<grid[0].length && (grid[i][j] == 0 || grid[i][j] == 2) && !used[i][j]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        UniquePathsIII980Solution solution = new UniquePathsIII980Solution();
        int[][] grid = new int[][]{
                {2}
        };
        System.out.println(solution.uniquePathsIII(grid));
    }
}
