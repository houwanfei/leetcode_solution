package com.hou.leetcode.solution.dp;


import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-15 9:48
 */
public class NumberMusicPlaylists920Solution {
    /**
     * 递归+备忘录
     * 思想：任意n首歌在K条件下组成len长度的种类，分两种情况，
     * 一种情况是在len长度时没有新增歌，那么在len位置时的选择有Math.max(0, n-K)种
     * 一种情况是在len长度时新增了歌,那么在len位置的选择有N-n种，因此
     *
     * @param N
     * @param L
     * @param K
     * @return
     */
    public int numMusicPlaylists(int N, int L, int K) {
        int[][] memo = new int[L+1][N+1];
        for (int i=0; i<=L; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(N, L, K, 0, 0, memo);
    }

    private int helper(int N, int L, int K, int len, int n, int[][] memo) {
        if (len > L || n > N) {
            return 0;
        }
        if (len == L) {
            if (n == N) {
                return 1;
            }
            return 0;
        }
        if (memo[len][n] != -1) {
            return memo[len][n];
        }
        int mod = (int) Math.pow(10, 9)+7;
        int sum = 0;
        for (int i=0; i<Math.max(0, n-K); i++) {
            sum = (sum + helper(N, L, K, len+1, n, memo))%mod;
        }
        for (int i=0; i<N-n; i++) {
            sum = (sum + helper(N, L, K, len+1, n+1, memo)) % mod;
        }
        return memo[len][n]= (sum%mod);
    }

    public static void main(String[] args) {
        NumberMusicPlaylists920Solution solution = new NumberMusicPlaylists920Solution();
        System.out.println(solution.numMusicPlaylists(3, 3, 1));
    }
}
