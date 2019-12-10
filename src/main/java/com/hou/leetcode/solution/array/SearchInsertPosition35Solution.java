package com.hou.leetcode.solution.array;

public class SearchInsertPosition35Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int s = 0, e=nums.length-1;
        while (s < e) {
            int mid = (s+e)/2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target){
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[s] < target? s+1:s;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(new SearchInsertPosition35Solution().searchInsert(nums, 7));
    }
}
