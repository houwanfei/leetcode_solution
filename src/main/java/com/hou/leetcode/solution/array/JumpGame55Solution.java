package com.hou.leetcode.solution.array;

public class JumpGame55Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        for (int i=1; i<nums.length; i++){
            dp[i] = false;
        }
        dp[0] = true;
        for (int i=0; i<nums.length;i++) {
            if (dp[nums.length-1]){
                return true;
            }
            if (dp[i]) {
                int index = 1;
                while (index <= nums[i] && i+index<nums.length) {
                    dp[i + index++] = true;
                }
            }
        }
        return dp[nums.length-1];
    }

    public boolean canJump2(int[] nums) {
        int max = 0;
        int index =0;
        while (index <= max) {
            if (max >= nums.length-1){
                return true;
            }
            max = Math.max(max, nums[index] + index);
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] nums1 = new int[]{3,2,1,0,4};
        JumpGame55Solution solution = new JumpGame55Solution();
//        System.out.println(solution.canJump(nums));
//        System.out.println(solution.canJump(nums1));

        System.out.println(solution.canJump2(nums));
        System.out.println(solution.canJump2(nums));
    }
}
