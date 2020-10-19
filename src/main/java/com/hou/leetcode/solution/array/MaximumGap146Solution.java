package com.hou.leetcode.solution.array;

public class MaximumGap146Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        sort(nums, 0, nums.length-1);
        int ans = 0;
        for (int i=1; i<nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i-1]);
        }
        return ans;
    }

    private void sort(int[] nums, int i, int j) {
        if (i>=j) {
            return;
        }
        int start=i, end=j;
        int mark = nums[i];
        while(i<j) {
            while(i<j && nums[j]>=mark) {
                j--;
            }
            if (i<j) {
                nums[i++] = nums[j];
            }
            while(i<j && nums[i]<=mark) {
                i++;
            }
            if (i<j) {
                nums[j--]=nums[i];
            }
        }
        nums[j] = mark;
        sort(nums, start, j);
        sort(nums, j+1, end);
    }

    public static void main(String[] args) {
        MaximumGap146Solution solution = new MaximumGap146Solution();
        int[] nums = new int[]{1,1,1,1};
        System.out.println(solution.maximumGap(nums));
    }
}
