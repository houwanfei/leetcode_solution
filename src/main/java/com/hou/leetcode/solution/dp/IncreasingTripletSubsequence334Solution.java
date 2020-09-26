package com.hou.leetcode.solution.dp;

public class IncreasingTripletSubsequence334Solution {


    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <3) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[i] >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length <3) {
            return false;
        }
        int one = Integer.MAX_VALUE,two = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < one) {
                one = nums[i];
            } else if (nums[i] > one && nums[i] < two) {
                two = nums[i];
            } else if (nums[i] > two) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence334Solution solution = new IncreasingTripletSubsequence334Solution();
        int[] nums = new int[]{5,4,3,2,1};
        System.out.println(solution.increasingTriplet2(nums));
    }
}
