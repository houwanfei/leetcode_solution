package com.hou.leetcode.solution.binary;

/**
 * @Description
 * 二分查找递归实现
 * @auther houwf
 * @create 2019-12-03 14:00
 */
public class SearchRotatedSortedArray33Solution {
    public int search(int[] nums, int target){
        if (nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int begin, int end, int target) {
        if (begin == end) {
            if (nums[begin] == target) {
                return begin;
            } else {
                return -1;
            }
        }
        if (nums[begin] < nums[end] && (nums[begin] > target || nums[end] < target)) {
            return -1;
        } else {
            int result1 = search(nums, begin, (begin +end)/2, target);
            int result2 = search(nums, (begin +end)/2 + 1, end, target);
            if (result1 != -1) {
                return result1;
            } else {
                return result2;
            }
        }
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray33Solution solution = new SearchRotatedSortedArray33Solution();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
    }
}
