package com.hou.leetcode.solution.dp;


public class PartitionKEqualSumSubsets698Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        return helper(nums, 0, new boolean[nums.length], k, sum, 0);
    }

    private boolean helper(int[] nums, int start, boolean[] used, int k, int sum, int currSum) {
        if (k == 1) {//最后一次不用计算，如果前边满足，最后一次肯定满足
            return true;
        }
        if (sum < currSum) {
            return false;
        }
        if (sum == currSum) {
            return helper(nums, 0, used, k-1, sum, 0);
        }
        for (int i=start; i<nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (helper(nums, i, used, k, sum, currSum+nums[i])) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12,1,2,3,18,2,5,2,11,1};
        PartitionKEqualSumSubsets698Solution solution = new PartitionKEqualSumSubsets698Solution();
        System.out.println(solution.canPartitionKSubsets(nums, 3));
    }
}
