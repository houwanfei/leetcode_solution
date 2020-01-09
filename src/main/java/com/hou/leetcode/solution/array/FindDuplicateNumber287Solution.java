package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-01-08 16:21
 */
public class FindDuplicateNumber287Solution {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length -1;
        while (start < end) {
            int mid = (start + end)/2;
            int count = 0;
            for (int i=0; i< nums.length; i++) {
                if (nums[i] <= mid){
                    count ++;
                }
            }
            if (count > mid) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        FindDuplicateNumber287Solution solution = new FindDuplicateNumber287Solution();
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums));
    }
}
