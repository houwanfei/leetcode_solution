package com.hou.leetcode.solution.dp;

public class DominoTrominoTiling790Solution {
    /**
     * 递归+备忘录
     * @param N
     * @return
     */
    public int numTilings(int N) {
        return helper(N, new int[N+1]);
    }

    private int helper(int N, int[] memo) {
        if (N <= 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 5;
        }
        if (memo[N] > 0) {
            return memo[N];
        }
        int mod = (int)Math.pow(10, 9)+7;
        int res = helper(N-1, memo)%mod;
        res = (res + helper(N-2, memo)%mod)%mod;
        for (int i=3; i<=N; i=i+2) {
            res = (res + 2*(helper(N-i, memo))%mod)%mod;
        }
        for (int i=4; i<=N; i=i+2) {
            res = (res + 2*(helper(N-i, memo))%mod)%mod;
        }
        return memo[N] = res;
    }

    public int numTilings2(int N) {
        if (N <= 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 5;
        }
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int mod = (int)Math.pow(10, 9)+7;
        for (int i=4; i<=N;i++) {
            dp[i] = (dp[i-1]+dp[i-2])%mod;
            for (int j=3; j<=i; j=j+2) {
                dp[i] = (dp[i] + 2*dp[i-j]%mod)%mod;
            }
            for (int j=4; j<=i; j=j+2) {
                dp[i] = (dp[i] + 2*dp[i-j]%mod)%mod;
            }
        }
        return dp[N];
    }

    /**
     * 化简上边的状态转移方程
     * dp[n] = dp[n-1] + dp[n-2] + 2 * (dp[n-3] + ... + dp[0])
     *       = dp[n-1] + dp[n-3] + dp[n-2] + dp[n-3] + 2 * (dp[n-4] + ... dp[0])
     *       = dp[n-1] + dp[n-3] + dp[n-1]
     *       = 2 * dp[n-1] + dp[n-3]
     * @param N
     * @return
     */
    public int numTilings3(int N) {
        if (N <= 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 5;
        }
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int mod = (int)Math.pow(10, 9)+7;
        for (int i=4; i<=N;i++) {
            dp[i] = 2*dp[i-1]%mod;
            dp[i] = (dp[i] + dp[i-3])%mod;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        DominoTrominoTiling790Solution solution = new DominoTrominoTiling790Solution();
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.numTilings(1000));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(solution.numTilings3(1000));
        System.out.println("end:" + System.currentTimeMillis());
    }
}
