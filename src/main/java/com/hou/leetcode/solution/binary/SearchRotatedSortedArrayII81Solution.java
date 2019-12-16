package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-16 14:24
 */
public class SearchRotatedSortedArrayII81Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return search(nums, target, 0, nums.length-1);
    }

    private boolean search(int[] nums, int target, int low, int hi) {
        if (low == hi){
            if (nums[low] == target) {
                return true;
            } else {
                return false;
            }
        }
        if (nums[low] < nums[hi] && (nums[low] > target || nums[hi] < target)) {
            return false;
        }
        int mid = (low + hi) / 2;
        return search(nums, target, low, mid) || search(nums, target, mid+1, hi);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        SearchRotatedSortedArrayII81Solution solution = new SearchRotatedSortedArrayII81Solution();
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
    }
}
