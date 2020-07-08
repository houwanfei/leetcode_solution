package com.hou.leetcode.solution.sliding_window;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-08 16:29
 */
public class LongestSubarrayAbsoluteDiffLimit1438Solution {
    /**
     * 记录最大最小值 避免每次都去比较，
     * 更好的办法是创建两个优先队列，一个从小到大 一个从大到小 记录下标，避免遍历
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int begin = 0;
        int end = 0;
        int max = 0;
        int maxNum = nums[0];
        int minNum = nums[0];
        while (end < nums.length) {
            if (Math.abs(maxNum - nums[end]) > limit || Math.abs(minNum - nums[end]) > limit) {
                maxNum = Integer.MIN_VALUE;
                minNum = Integer.MAX_VALUE;
                int index = end;
                while (index>=begin) {
                    if (Math.abs(nums[index] - nums[end]) > limit) {
                        begin = index+1;
                        break;
                    }
                    maxNum = Math.max(maxNum, nums[index]);
                    minNum = Math.min(minNum, nums[index]);
                    index--;
                }
            } else {
                maxNum = Math.max(maxNum, nums[end]);
                minNum = Math.min(minNum, nums[end]);
                max = Math.max(max, end - begin + 1);
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarrayAbsoluteDiffLimit1438Solution solution = new LongestSubarrayAbsoluteDiffLimit1438Solution();
        int[] nums = new int[]{8,2,4,7};
        System.out.println(solution.longestSubarray(nums, 4));
    }
}
