package com.hou.leetcode.solution.array;

import java.util.Arrays;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-25 17:43
 */
public class ThreeSumClosest16Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i=0; i<nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int sum = nums[i] + nums[start] +nums[end];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,2,1,-3};
        ThreeSumClosest16Solution solution = new ThreeSumClosest16Solution();
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}
