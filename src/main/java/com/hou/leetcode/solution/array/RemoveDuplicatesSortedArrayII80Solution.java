package com.hou.leetcode.solution.array;

public class RemoveDuplicatesSortedArrayII80Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[index]) {
                count++;
                if (count <= 2){
                    index++;
                    nums[index] = nums[i];
                }
            } else {
                index++;
                count=1;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        RemoveDuplicatesSortedArrayII80Solution solution = new RemoveDuplicatesSortedArrayII80Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}
