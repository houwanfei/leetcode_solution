package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-08-19 15:52
 */
public class KnightProbabilityChessboard688Solution {
    /**
     * 思路：每一步都有8种跳法，要求K步在棋盘内的概率，只需要求出8种K-1步在棋盘概率和/8就是K步的概率
     *
     * 递归+备忘录
     * @param N
     * @param K
     * @param r
     * @param c
     * @return
     */
    public double knightProbability(int N, int K, int r, int c) {
        return helper(N, K, r, c, new double[K+1][N][N]);
    }

    private double helper(int N, int K, int r, int c, double[][][] memo) {
        if (r > N-1 || r < 0 || c > N-1 || c < 0) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (memo[K][r][c] > 0) {
            return memo[K][r][c];
        }
        int[][] jumps = new int[][]{{-2, -1},{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2}};
        double ans = 0.0;
        for (int[] jump : jumps) {
            ans += helper(N, K-1, r+jump[0], c+jump[1], memo);
        }
        return memo[K][r][c] = ans/8.0;
    }

    /**
     * 改写 bottom to top
     * 空间复杂度 O(KN^2)
     * 空间复杂度可以降低，因为只用了K-1的状态
     * @param N
     * @param K
     * @param r
     * @param c
     * @return
     */
    public double knightProbability2(int N, int K, int r, int c) {
        double[][][] dp = new double[K+1][N][N];
        int[][] jumps = new int[][]{{-2, -1},{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2}};
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                dp[0][i][j] = 1;
            }
        }
        for (int k=1; k<=K; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    double ans = 0.0;
                    for (int[] jump : jumps) {
                        if (check(i+jump[0], j+jump[1], N)) {
                            ans += dp[k-1][i+jump[0]][j+jump[1]];
                        }
                    }
                    dp[k][i][j] = ans/8.0;
                }
            }
        }
        return dp[K][r][c];
    }

    /**
     * 改写
     * 降低空间复杂度，因为只用了K-1的状态
     * 空间复杂度 O(N^2)
     * @param N
     * @param K
     * @param r
     * @param c
     * @return
     */
    public double knightProbability3(int N, int K, int r, int c) {
        double[][] prev = new double[N][N];
        int[][] jumps = new int[][]{{-2, -1},{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2}};
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                prev[i][j] = 1;
            }
        }
        for (int k=1; k<=K; k++) {
            double[][] curr = new double[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    double ans = 0.0;
                    for (int[] jump : jumps) {
                        if (check(i+jump[0], j+jump[1], N)) {
                            ans += prev[i+jump[0]][j+jump[1]];
                        }
                    }
                    curr[i][j] = ans/8.0;
                }
            }
            prev = curr;
        }
        return prev[r][c];
    }

    private boolean check(int r, int c, int N) {
        if (r > N-1 || r < 0 || c > N-1 || c < 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KnightProbabilityChessboard688Solution solution = new KnightProbabilityChessboard688Solution();
        System.out.println("begin" + System.currentTimeMillis());
        System.out.println(solution.knightProbability(50, 100, 12, 12));
        System.out.println("end" + System.currentTimeMillis());
        System.out.println(solution.knightProbability2(50, 100, 12, 12));
        System.out.println("end2" + System.currentTimeMillis());
        System.out.println(solution.knightProbability3(50, 100, 12, 12));
    }
}
