package com.hou.leetcode.solution.dp;

public class ContinuousSubArraySum523Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int sum =0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            int subSum = sum;
            int j=0;
            while ((subSum == 0 ||subSum >= k) && j<i) {
                if (subSum == 0 || (k!=0 && subSum % k ==0)) {
                    return true;
                }
                subSum -= nums[j++];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8};
        System.out.println(new ContinuousSubArraySum523Solution().checkSubarraySum(nums, 6));
    }
}
