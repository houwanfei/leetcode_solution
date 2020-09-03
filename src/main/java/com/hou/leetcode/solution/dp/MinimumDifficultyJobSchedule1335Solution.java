package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-02 9:53
 */
public class MinimumDifficultyJobSchedule1335Solution {
    /**
     * 递归思想
     * 要求d天的最小难度，只需要求 min(第d天[d,...,len]到len范围的最大值+前d-1天的最小难度)
     *
     * 然后加上备忘录，从递归参数可以看到备忘录是一个二维数组，d和i
     * @param jobDifficulty
     * @param d
     * @return
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        int[][] memo = new int[jobDifficulty.length][d+1];
        for (int i=0; i<jobDifficulty.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int res = helper(jobDifficulty, d, jobDifficulty.length-1, memo);
        return res == Integer.MAX_VALUE?-1:res;
    }

    private int helper(int[] jobDifficulty, int d, int i, int[][] memo) {
        if (d == 0) {
            if (i < 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (memo[i][d] != -1) {
            return memo[i][d];
        }
        int max = 0;
        int res = Integer.MAX_VALUE;
        for (int j=i;j>=d-1; j--) {
            max = Math.max(max, jobDifficulty[j]);
            int tmp = helper(jobDifficulty, d-1, j-1, memo);
            if (tmp == Integer.MAX_VALUE) {
                continue;
            }
            res = Math.min(res, tmp+max);
        }
        return memo[i][d] = res;
    }

    /**
     * 至底向上
     *
     * @param jobDifficulty
     * @param d
     * @return
     */
    public int minDifficulty2(int[] jobDifficulty, int d) {
        int[][] dp = new int[jobDifficulty.length+1][d+1];
        for (int i=0; i<jobDifficulty.length; i++) {
            for (int k=1; k<=d && k<= i+1; k++) {
                dp[i+1][k] = Integer.MAX_VALUE;
                int max = 0;
                for (int j=i; j>=k-1; j--) {
                    max = Math.max(max, jobDifficulty[j]);
                    if (k==1 && j!=0) {
                        continue;
                    }
                    dp[i+1][k] = Math.min(dp[i+1][k], dp[j][k-1]+max);
                }
            }
        }
        return dp[jobDifficulty.length][d];
    }

    public static void main(String[] args) {
        MinimumDifficultyJobSchedule1335Solution solution = new MinimumDifficultyJobSchedule1335Solution();
//        int[] jobs = new int[]{6,5,4,3,2,1};
        int N = 1000;
        int[] jobs = new int[N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N;i++) {
            jobs[i] = random.nextInt(1000);
            stringBuilder.append(jobs[i]);
            if (i<N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        int d = random.nextInt(10);
        System.out.println(d);
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.minDifficulty(jobs, d));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(solution.minDifficulty2(jobs, d));
        System.out.println("end2:" + System.currentTimeMillis());
    }
}
