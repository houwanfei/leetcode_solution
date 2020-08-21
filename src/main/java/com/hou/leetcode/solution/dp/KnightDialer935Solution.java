package com.hou.leetcode.solution.dp;

public class KnightDialer935Solution {
    /**
     * 递归思想：比如要求1位置的n步跳法，只需要求解1可以跳的位置的n-1步跳法的和
     * @param n
     * @return
     */
    public int knightDialer(int n) {
        int mod = (int)Math.pow(10, 9) + 7;
        int res = 0;
        int[][][] memo = new int[n][4][3];
        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                res = (res +helper(n-1, i, j, memo))%mod;
            }
        }
        return res;
    }

    private int helper(int n, int i, int j, int[][][] memo) {
        if ((i == 3 && (j==0 || j==2)) || i < 0 || i>3 || j<0 || j>2) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        if (memo[n][i][j] > 0) {
            return memo[n][i][j];
        }
        int[][] jumps = new int[][]{{-2, -1},{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2}};
        int mod = (int)Math.pow(10, 9) + 7;
        int res = 0;
        for (int[] jump : jumps) {
            res = (res+helper(n-1, i+jump[0], j+jump[1], memo))%mod;
        }
        return memo[n][i][j] = res;
    }

    /**
     * bottom top
     *
     * @param n
     * @return
     */
    public int knightDialer2(int n) {
        int mod = (int)Math.pow(10, 9) + 7;
        int[][] prev = new int[4][3];
        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                if (i == 3 && (j==0 || j==2)) {
                    continue;
                }
                prev[i][j] = 1;
            }
        }
        int[][] jumps = new int[][]{{-2, -1},{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2}};
        for (int k=1; k<n; k++) {
            int[][] curr = new int[4][3];
            for (int i=0; i<4; i++) {
                for (int j=0; j<3; j++) {
                    if ((i == 3 && (j==0 || j==2))) {
                        continue;
                    }
                    for (int[] jump : jumps) {
                        int indexi = i+jump[0];
                        int indexj = j+jump[1];
                        if (indexi < 0 || indexi>3 || indexj<0 || indexj>2) {
                            continue;
                        }
                        curr[i][j] = (curr[i][j]+prev[indexi][indexj])%mod;
                    }
                }
            }
            prev = curr;
        }
        int ans = 0;
        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                if (i == 3 && (j==0 || j==2)) {
                    continue;
                }
                ans = (ans + prev[i][j])%mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KnightDialer935Solution solution = new KnightDialer935Solution();
        System.out.println("begin"+System.currentTimeMillis());
        System.out.println(solution.knightDialer(5000));
        System.out.println("end"+System.currentTimeMillis());
        System.out.println(solution.knightDialer2(5000));
        System.out.println("end1"+System.currentTimeMillis());
    }
}
