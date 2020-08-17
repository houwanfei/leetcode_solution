package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-17 12:24
 */
public class StoneGameIII1406Solution {
    /**
     * 递归+备忘录 数组太大 层数太深 stackoverflow
     * @param stoneValue
     * @return
     */
    public String stoneGameIII(int[] stoneValue) {
        int[] memo = new int[stoneValue.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        int res = helper(stoneValue, 0, memo);
        if (res > 0) {
            return "Alice";
        } else if (res == 0) {
            return "Tie";
        }else {
            return "Bob";
        }
    }

    private int helper(int[] stoneValue, int s, int[] memo) {
        if (s >= stoneValue.length) {
            return 0;
        }
        if (memo[s] != Integer.MIN_VALUE) {
            return memo[s];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=1; i<=3; i++) {
            if (s+i-1 >= stoneValue.length) {
                continue;
            }
            sum += stoneValue[s+i-1];
            max = Math.max(max, sum-helper(stoneValue, s+i, memo));
        }
        return memo[s] = max;
    }

    /**
     * bottom to top
     * 利用dp记录当前位置开始的选手选择方案比对手多得的分的最大值
     * 最后比较dp[0]的值，该值是Alice比Bob多的得分，如果为负说明Alice的石子数比Bob少
     * @param stoneValue
     * @return
     */
    public String stoneGameIII2(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        dp[stoneValue.length-1] = stoneValue[stoneValue.length-1];
        for (int i=stoneValue.length-2; i>=0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int j=1; j<=3 && i+j-1 < stoneValue.length; j++) {
                sum+=stoneValue[i+j-1];
                if (i+j >= stoneValue.length) {
                    dp[i] = Math.max(dp[i], sum);
                    continue;
                }
                dp[i] = Math.max(dp[i], sum-dp[i+j]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] == 0) {
            return "Tie";
        }else {
            return "Bob";
        }
    }

    public static void main(String[] args) {
        StoneGameIII1406Solution solution = new StoneGameIII1406Solution();
        int N = 5000;
        int[] nums = new int[]{-1,-2};
//        int[] nums = new int[N];
//        Random random = new Random();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        for (int i=0; i<N; i++) {
//            int flag = random.nextInt(3)>1?-1:1;
//            nums[i] = flag * random.nextInt(1000);
//            stringBuilder.append(nums[i]);
//            if (i < N-1) {
//                stringBuilder.append(",");
//            }
//        }
//        stringBuilder.append("]");
//        System.out.println(stringBuilder.toString());
        System.out.println(solution.stoneGameIII(nums));
        System.out.println(solution.stoneGameIII2(nums));
    }

}
