package com.hou.leetcode.solution.binary;

public class FindPeakElement162Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        int s = 0, e= nums.length-1;
        while (s <= e) {
            int mid = s + (e-s)/2;
            if (mid != 0 &&nums[mid] < nums[mid-1]) {
                e = mid-1;
            } else if (mid != nums.length-1 && nums[mid] < nums[mid+1]) {
                s = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new FindPeakElement162Solution().findPeakElement(nums));
    }
}
