package com.hou.leetcode.solution.array;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-17 15:27
 */
public class KthLargestElementArray215Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || nums.length == 0) {
            return 0;
        }
        return helper(nums, k-1, 0, nums.length-1);
    }

    private int helper(int[] nums, int k, int start, int end) {
        int i=start, j=end;
        int mark = nums[start];
        while (i != j) {
            while (nums[j] <= mark && j > i) {
                j--;
            }
            while (nums[i] >= mark && i < j) {
                i++;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[start] = nums[i];
        nums[i] = mark;
        if (i == k) {
            return nums[i];
        } else if (i < k) {
            return helper(nums, k, i+1, end);
        } else {
            return helper(nums, k, start, i-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new KthLargestElementArray215Solution().findKthLargest(nums, 6));
    }
}
