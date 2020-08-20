package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-20 18:36
 */
public class StudentAttendanceRecordII552Solution {
    public int checkRecord(int n) {
        return helper(n, 1, 2, new int[n+1][2][3]);
    }

    /**
     * a l p
     * @param n
     * @param a
     * @param l
     * @return
     */
    private int helper(int n, int a, int l, int[][][] memo) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][a][l] > 0) {
            return memo[n][a][l];
        }
        int mod = (int)Math.pow(10, 9) +7;
        //p
        int res = helper(n-1, a, 2, memo)%mod;
        if (a > 0) {
            res = (res + helper(n-1, a-1, 2, memo))%mod;
        }
        if (l > 0) {
            res = (res + helper(n-1, a, l-1, memo))%mod;
        }
        return memo[n][a][l] = res;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII552Solution solution = new StudentAttendanceRecordII552Solution();
        System.out.println(solution.checkRecord(100000));
    }
}
