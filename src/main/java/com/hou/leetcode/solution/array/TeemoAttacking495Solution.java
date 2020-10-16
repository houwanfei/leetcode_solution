package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-16 14:16
 */
public class TeemoAttacking495Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length ==0) {
            return 0;
        }
        int ans = duration;
        for (int i=1; i<timeSeries.length; i++) {
            ans += Math.min(duration, timeSeries[i]-timeSeries[i-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4};
        TeemoAttacking495Solution solution = new TeemoAttacking495Solution();
        System.out.println(solution.findPoisonedDuration(nums, 2));
    }
}
