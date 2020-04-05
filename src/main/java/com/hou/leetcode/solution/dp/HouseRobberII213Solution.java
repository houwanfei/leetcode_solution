package com.hou.leetcode.solution.dp;

/**
 * @Description 偷房子 房子是一个圈 所以第一个和最后一个相邻不能同时偷，
 * 就算两次，一个包含第一个房子，一个包含最后一个房子
 * @auther houwf
 * @create 2020-03-26 15:53
 */
public class HouseRobberII213Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length-1), helper(nums, 1, nums.length));
    }
    private int helper(int[] nums, int start, int end) {
        int preTwo = 0;
        int pre = 0;
        for (int i=start; i<end; i++) {
            int tmp = preTwo + nums[i];
            preTwo = pre;
            pre = Math.max(tmp, pre);
        }
        return Math.max(preTwo, pre);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new HouseRobberII213Solution().rob(nums));
    }
}
