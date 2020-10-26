package com.hou.leetcode.solution.array;

public class SubarrayProductLessThanK713Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) {
            return 0;
        }
        int start=0;
        int product = 1;
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            product *= nums[i];
            while (start<=i && product >= k) {
                product /= nums[start++];
            }
            ans += i-start+1;
        }
        return ans;
    }
}
