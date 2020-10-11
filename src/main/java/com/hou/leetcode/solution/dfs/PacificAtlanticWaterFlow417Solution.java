package com.hou.leetcode.solution.dfs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow417Solution {

    /**
     * DFS解法， 可以拆分成两个dfs，可以利用memo
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                boolean[] res = dfs(matrix, i, j, new boolean[matrix.length][matrix[0].length]);
                if (res[0] && res[1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private boolean[] dfs(int[][] matrix, int i, int j, boolean[][] used) {
        if (i<0 || j<0) {
            return new boolean[]{true, false};
        }
        if (i>=matrix.length || j>=matrix[0].length) {
            return new boolean[]{false, true};
        }
        int[][] directions = new int[][]{{-1, 0}, {0,1}, {1, 0}, {0, -1}};
        boolean[] ans = new boolean[2];
        used[i][j] = true;
        for (int[] direct : directions) {
            if (i+direct[0] >= 0 && i+direct[0] < matrix.length
                    && j+direct[1]>=0 && j+direct[1]<matrix[0].length
                    && (matrix[i][j] < matrix[i+direct[0]][j+direct[1]]
                    || used[i+direct[0]][j+direct[1]])) {
                continue;
            }
            boolean[] res = dfs(matrix, i+direct[0], j+direct[1], used);
            ans[0] |= res[0];
            ans[1] |= res[1];
        }
        return ans;
    }


    /**
     * BFS解法
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow417Solution solution = new PacificAtlanticWaterFlow417Solution();
        int[][] matrix = new int[][] {
                {1   ,2   ,2  ,3 ,5},
                {3   ,2   ,3  ,4 ,4},
                {2   ,4   ,5  ,3  ,1},
                {6   ,7   ,1  ,4,  5},
                {5,  1,   1,   2,   4}
        };
        List<List<Integer>> res = solution.pacificAtlantic(matrix);
        System.out.println();
    }
}
