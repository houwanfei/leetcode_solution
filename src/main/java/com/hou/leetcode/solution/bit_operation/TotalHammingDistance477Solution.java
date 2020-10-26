package com.hou.leetcode.solution.bit_operation;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-22 14:05
 */
public class TotalHammingDistance477Solution {
    /**
     * 思路：输入数字是int类型，因为32位，
     * 可以考虑统计每一位1的次数，那么0的次数为nums.length-count[j]，所以不同的组合数为(nums.length-count[j])*count[j]
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] count = new int[32];
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<32; j++) {
                count[j] += ((nums[i]>>j) & 1);
            }
        }
        int ans = 0;
        for (int i=0; i<32; i++) {
            ans += (nums.length-count[i])*count[i];
        }
        return ans;
    }
}
