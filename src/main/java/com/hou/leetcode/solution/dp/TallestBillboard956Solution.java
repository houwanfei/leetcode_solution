package com.hou.leetcode.solution.dp;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-26 14:25
 */
public class TallestBillboard956Solution {
    public int tallestBillboard(int[] rods) {
        return helper(rods, 0, 0, rods.length-1, new HashMap<>());
    }

    private int helper(int[] rods, int b1, int b2, int i, Map<String, Integer> memo) {
        if (i == -1) {
            if (b1 == b2) {
                return b1;
            }
            return 0;
        }
        String key = i+":"+b1+":"+b2;
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        int res1 = helper(rods, b1+rods[i], b2, i-1, memo);
        int res2 = helper(rods, b1, b2+rods[i], i-1, memo);
        int res3 = helper(rods, b1, b2, i-1, memo);
        int res = Math.max(res1, Math.max(res2, res3));
        memo.put(key, res);
        return res;
    }

    /**
     * 用dp[i][j]存储前i个元素分为两组，差值为j的大的子数组和，在计算i时有三种情况
     * 1. rods[i]加入大的子数组中，那么差值更大了 dp[i][j] = dp[i-1][j-rods[i]]+rods[i]
     * 2. rods[i]加入小的子数组中，但是小的子数组和依然小于大的子数组和，那么 dp[i][j] = dp[i-1][j+rods[i]]
     * 3. rods[i]加入小的子数组，并且小的子数组和大于了大的子数组和，因此，这里会变换 dp[i][j] = dp[i-1][rods[i]-j]+j
     *
     * 最终dp[n][0]就是所有元素分组后差值为0的子数组最大和
     *
     * dp的思想是尽量缩减状态
     *
     * @param rods
     * @return
     */
    public int tallestBillboard2(int[] rods) {
        int[][] dp = new int[rods.length+1][5001];
        for (int i=0; i<5001; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        dp[0][0] = 0;
        for (int i=1; i<=rods.length; i++) {
            for (int j=0;j<5001; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>=rods[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-rods[i-1]]+rods[i-1]);
                }
                if (j < rods[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][rods[i-1]-j]+j);
                }
                if (rods[i-1]+j <= 5000) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j+rods[i-1]]);
                }
            }
        }
        return dp[rods.length][0];
    }

    public static void main(String[] args) {
        TallestBillboard956Solution solution = new TallestBillboard956Solution();
//        int[] rods = new int[]{1,2,3,4,5,6,7,8,9,29,10,11,12,13,14,15,16,17,18,19,45};
        int N = 15;
        int[] rods = new int[N];
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        stringBuilder.append("[");
        for (int i=0;i<N; i++) {
            rods[i] = random.nextInt(1000);
            stringBuilder.append(rods[i]);
            if (i != N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println("begin:" + System.currentTimeMillis());
//        System.out.println(solution.tallestBillboard(rods));
        System.out.println(solution.tallestBillboard2(rods));
        System.out.println("end:" + System.currentTimeMillis());
    }
}
