package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-07 12:44
 */
public class SuperWashingMachines517Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i=0; i<machines.length; i++) {
            sum += machines[i];
        }
        if (sum %machines.length != 0) {
            return -1;
        }
        int num = sum/machines.length;
        int ans = 0;
        int[] dp = new int[machines.length+1];
        dp[0] = 0;
        for (int i=1; i<=machines.length; i++) {
            dp[i] = dp[i-1] + machines[i-1] - num;
            ans += Math.abs(dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        SuperWashingMachines517Solution solution = new SuperWashingMachines517Solution();
        int[] machines = new int[]{1,0,5};
        System.out.println(solution.findMinMoves(machines));
    }
}
