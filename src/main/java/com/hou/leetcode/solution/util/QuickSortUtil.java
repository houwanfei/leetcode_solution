package com.hou.leetcode.solution.util;

/**
 * @auther houwanfei
 * @create 2018-09-14 下午3:59
 */
public class QuickSortUtil {
    public static void sort(int start, int end, int[] nums){
        if (start >= end)
            return;
        int mark = nums[start];
        int low = start;
        int high = end;
        while (start < end){
            while (end > start && nums[end] >= mark){
                end--;
            }
            if (start < end)
                nums[start++] = nums[end];

            while (start < end && nums[start] <= mark){
                start++;
            }
            if (end > start)
                nums[end--] = nums[start];
        }
        nums[end] = mark;
        sort(low, end, nums);
        sort(end+1, high, nums);
    }
}
