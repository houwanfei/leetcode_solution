package com.hou.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 回溯法
 * @auther houwf
 * @create 2019-12-20 12:03
 */
public class NQueens51Solution {
    private List<List<String>> res = null;
    private int[] queens = null;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        this.queens = new int[n];
        backtracking(0, n);
        return res;
    }

    private void backtracking(int rowIndex, int n) {
        if (rowIndex >= n) {
            List<String> tmpRes = new ArrayList<>();
            for (int i=0; i<n;i ++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n;j++) {
                    if (queens[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tmpRes.add(sb.toString());
            }
            res.add(tmpRes);
        }

        for (int i=0; i<n; i++) {
            if (checkValid(rowIndex, i)) {
                //可以放在这个位置
                queens[rowIndex] = i;
                backtracking(rowIndex+1, n);
            }
        }
    }

    private boolean checkValid(int rowIndex, int colIndex) {
        for (int i=0; i< rowIndex; i++) {
            if (queens[i] == colIndex || (Math.abs(i-rowIndex) == Math.abs(queens[i]-colIndex))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens51Solution solution = new NQueens51Solution();
        List<List<String>> res = solution.solveNQueens(0);
        System.out.println();
    }
}
