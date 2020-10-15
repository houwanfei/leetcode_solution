package com.hou.leetcode.solution.array;

public class MissingNumber268Solution {

    /**
     * 异或运算特性
     * a^a=0
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i=0; i<nums.length; i++) {
            ans = ans^i^nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 1};
        MissingNumber268Solution solution = new MissingNumber268Solution();
        System.out.println(solution.missingNumber(nums));
    }
}
