package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-16 16:11
 */
public class FindMinimumRotatedSortedArray153Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1){
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
        int l = 0, r = nums.length-1;
        while (l+1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return Math.min(nums[l], nums[r]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums2 = new int[]{3,4,5,1,2};
        FindMinimumRotatedSortedArray153Solution solution = new FindMinimumRotatedSortedArray153Solution();
        System.out.println(solution.findMin(nums));
        System.out.println(solution.findMin(nums2));
        System.out.println(solution.searchMin(nums));
        System.out.println(solution.searchMin(nums2));
    }
}
