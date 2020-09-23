package com.hou.leetcode.solution.backtracking;

public class NQueensII52Solution {
    int count;
    public int totalNQueens(int n) {
        if (n<=1) {
            return 1;
        }
        backtracking(0, n, new int[n]);
        return count;
    }

    private void backtracking(int row, int n, int[] queens) {
        if (row == n) {
            count++;
            return;
        }
        for (int i=0;i<n; i++) {
            if (check(row, i, queens)) {
                queens[row] = i;
                backtracking(row+1, n, queens);
            }
        }
    }

    private boolean check(int row, int col, int[] queens) {
        for (int i=0; i<row; i++) {
            if (queens[i] == col || (Math.abs(queens[i]-col) == Math.abs(row - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII52Solution solution = new NQueensII52Solution();
        System.out.println(solution.totalNQueens(10));
    }
}
