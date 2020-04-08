package com.hou.leetcode.solution.array;

import java.util.Arrays;

public class SingleNumberII137Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        int sum = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                sum++;
            } else {
                if (sum < 3) {
                    return nums[i];
                }
                sum = 1;
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
        SingleNumberII137Solution solution = new SingleNumberII137Solution();
        System.out.println(solution.singleNumber(nums));
    }
}
