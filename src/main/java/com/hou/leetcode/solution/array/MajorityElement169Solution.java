package com.hou.leetcode.solution.array;

public class MajorityElement169Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int candidated=nums[0],voted=1;
        for (int i=1; i<nums.length; i++) {
            if (candidated == nums[i]) {
                voted++;
            } else {
                if (voted == 0) {
                    candidated = nums[i];
                    voted = 1;
                } else {
                    voted--;
                }
            }
        }
        return candidated;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(new MajorityElement169Solution().majorityElement(nums));
    }
}
