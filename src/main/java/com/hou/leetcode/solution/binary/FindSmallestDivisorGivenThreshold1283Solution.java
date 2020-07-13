package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-13 10:58
 */
public class FindSmallestDivisorGivenThreshold1283Solution {
    /**
     * 思路：题目要求找一个最小满足threshold的除数，可以二分查找这个除数
     * 注意二分判断条件，mid越小，sum越大，因此要找到满足sum <= threshold的最左边的值，因此最后返回left
     * @param nums
     * @param threshold
     * @return
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1,right=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > right) {
                right = nums[i];
            }
        }
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(nums, mid) <= threshold) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int check(int[] nums, int mid) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += Math.ceil(nums[i]*1.0 / mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{19};
        FindSmallestDivisorGivenThreshold1283Solution solution = new FindSmallestDivisorGivenThreshold1283Solution();
        System.out.println(solution.smallestDivisor(nums, 5));
    }
}
