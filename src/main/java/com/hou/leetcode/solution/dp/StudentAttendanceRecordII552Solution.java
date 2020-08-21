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

    public int checkRecord2(int n) {
        if (n==0) {
            return 0;
        }
        if (n == 1) {
            return 3;
        }
        int[] p = new int[n];
        int[] a = new int[n];
        int[] l = new int[n];
        int[] pnoa = new int[n];
        int[] lnoa = new int[n];
        p[0] = 1;
        a[0] = 1;
        l[0] = 1;
        pnoa[0] = 1;
        lnoa[0] = 1;
        p[1] = 3;
        a[1] = 2;
        lnoa[1] = 2;
        pnoa[1] = 2;
        l[1] = 3;
        int mod = (int)Math.pow(10, 9) +7;
        for (int i=1; i< n; i++) {
            p[i] = ((p[i-1] + a[i-1])%mod + l[i-1])%mod;
            pnoa[i] = (pnoa[i-1] + lnoa[i-1])%mod;
            if (i>1) {
                l[i] = ((p[i - 1] + a[i - 1]) % mod + (p[i - 2] + a[i - 2]) % mod) % mod;
                lnoa[i] = (pnoa[i - 1] + pnoa[i - 2]) % mod;
            }
            a[i] = (pnoa[i-1] + lnoa[i-1])%mod;
        }
        return ((l[n-1] + p[n-1])%mod + a[n-1])%mod;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII552Solution solution = new StudentAttendanceRecordII552Solution();
//        System.out.println(solution.checkRecord(1000));
        System.out.println(solution.checkRecord2(100000));
    }
}
