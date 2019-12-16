package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-16 17:12
 */
public class FindMinimumRotatedSortedArrayII154Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return searchMin(nums, 0, nums.length-1);
    }
    private int searchMin(int[] nums, int low, int hi) {
        if (low == hi) {
            return nums[hi];
        }
        if (nums[low] < nums[hi]) {
            return nums[low];
        }

        int mid = (low + hi) / 2;
        int left = searchMin(nums, low, mid);
        int right = searchMin(nums, mid + 1, hi);
        return  left < right? left:right;
    }

    private int searchMin(int[] nums) {
        int l=0;
        int r = nums.length -1;
        while (l < r) {
            int mid = (l+r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArrayII154Solution solution = new FindMinimumRotatedSortedArrayII154Solution();
        int[] nums = new int[] {2,2,2,0,1};
        int[] nums2 = new int[] {1,3,5};
        System.out.println(solution.findMin(nums));
        System.out.println(solution.findMin(nums2));
        System.out.println(solution.searchMin(nums));
        System.out.println(solution.searchMin(nums2));
    }
}
