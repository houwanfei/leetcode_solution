package com.hou.leetcode.solution.array;

public class FirstMissingPositive41Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0) {
                return i+1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        FirstMissingPositive41Solution solution = new FirstMissingPositive41Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }
}
