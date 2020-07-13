package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-13 18:17
 */
public class SwimRisingWater778Solution {
    public int swimInWater(int[][] grid) {
        int left = 0;
        int right = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid.length; j++) {
                right = Math.max(right, grid[i][j]);
            }
        }

        while (left <= right) {
            int mid = (left + right)/2;
            if (check(grid, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] grid, int mid) {
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};
        int n = grid.length;
        int[] ids = new int[n*n];
        for (int i=0; i<n*n; i++) {
            ids[i] = i;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<4; k++){
                    int x = i + dirX[k];
                    int y = j + dirY[k];
                    if (insideBoard(n, n, x, y) && grid[x][y] <= mid && grid[i][j] <= mid){
                        union(ids, i*n+j, x*n+y);
                    }
                }
            }
        }
        return checkConnect(ids, 0, n*n-1);
    }

    private boolean insideBoard(int m, int n, int x, int y){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    private void union(int[] ids, int x, int y) {
        int i= find(ids, x);
        int j= find(ids, y);
        ids[j] = i;
    }

    private int find(int[] ids, int x) {
        while (x != ids[x]) {
            ids[x] = ids[ids[x]];
            x = ids[x];
        }
        return x;
    }

    private boolean checkConnect(int[] ids, int x, int y) {
        return find(ids, x) == find(ids, y);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        };
        System.out.println(new SwimRisingWater778Solution().swimInWater(grid));
    }
}
