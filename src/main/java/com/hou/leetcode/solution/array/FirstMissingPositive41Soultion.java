package com.hou.leetcode.solution.array;

public class FirstMissingPositive41Soultion {
    public int firstMissingPositive(int[] nums) {
        if (nums.length ==0) {
            return 0;
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0 || nums[i] == i+1 || nums[i] > nums.length) {
                continue;
            }
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums.length ==0) {
            return 0;
        }
        int i=0;
        while (i<nums.length) {
            if (nums[i] <= 0 || nums[i] == i+1 || nums[i] > nums.length) {
                i++;
                continue;
            }
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        FirstMissingPositive41Soultion soultion = new FirstMissingPositive41Soultion();
        System.out.println(soultion.firstMissingPositive2(nums));
    }
}
