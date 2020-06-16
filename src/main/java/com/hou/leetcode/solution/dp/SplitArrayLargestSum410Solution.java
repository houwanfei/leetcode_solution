package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-08 13:54
 */
public class SplitArrayLargestSum410Solution {
    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[m][nums.length];
        return helper(nums, m-1, nums.length-1, memo);
    }

    /**
     * 备忘录递归解法
     * @param nums
     * @param m
     * @param last
     * @param memo
     * @return
     */
    private int helper(int[] nums, int m, int last, int[][] memo) {
        if (m == 0) {
            if (last < 0) {
                return 0;
            } else {
                int sum = 0;
                for (int i=0; i<=last; i++) {
                    sum += nums[i];
                }
                return sum;
            }
        }
        if (memo[m][last] != 0) {
            return memo[m][last];
        }
        int sum = 0;
        int minMax = Integer.MAX_VALUE;
        for (int i=last; i>=m; i--) {
            sum += nums[i];
            minMax = Math.min(minMax, Math.max(sum, helper(nums, m-1, i-1, memo)));
        }
        return memo[m][last] = minMax;
    }

    /**
     * 二分查找，将答案做一个二分搜索，答案的最大值为数组的和，最小值为数组的最大值
     * 在这个范围内二分查找，统计按mid值划分的子数组数，如果子数组数大于m，则真正结果应该比mid大，如果小于m，说明正则结果比m小
     * @param nums
     * @param m
     * @return
     */
    public int splitArray2(int[] nums, int m) {
        int r = 0;
        int l = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        while (l < r) {
            int mid = (l+r)/2;
            if (binarySearch(nums, mid) <= m) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private int binarySearch(int[] nums, int target) {
        int count = 1;
        int currSum = 0;
        for (int num : nums) {
            if (currSum + num > target) {
                currSum = num;
                count++;
            } else {
                currSum += num;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        SplitArrayLargestSum410Solution solution = new SplitArrayLargestSum410Solution();
        System.out.println(solution.splitArray2(nums, 2));
    }
}
