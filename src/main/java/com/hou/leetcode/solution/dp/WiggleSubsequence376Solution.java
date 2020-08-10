package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-10 12:41
 */
public class WiggleSubsequence376Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2]; //0大于，1小于
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = 0;
            for (int j=i-1; j>=0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
                } else if (nums[i] < nums[j]){
                    dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
                }
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        WiggleSubsequence376Solution solution = new WiggleSubsequence376Solution();
        int[] num = new int[]{1};
        System.out.println(solution.wiggleMaxLength(num));
    }
}
