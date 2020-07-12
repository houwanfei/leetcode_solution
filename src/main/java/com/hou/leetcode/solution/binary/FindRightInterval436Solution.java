package com.hou.leetcode.solution.binary;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval436Solution {
    /**
     * 暴力求解 时间复杂度 O(n^2)
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[]{};
        }
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i<intervals.length; i++) {
            int min = Integer.MAX_VALUE;
            res[i] = -1;
            for (int j=0; j<intervals.length; j++) {
                if (j == i) {
                    continue;
                }
                if (intervals[i][intervals[0].length-1] <= intervals[j][0] && intervals[j][0] < min) {
                    min = intervals[j][0];
                    res[i] = j;
                }
            }
        }
        return res;
    }

    /**
     * 空间换时间，通过二分查找加速查找过程，要先构造一个数组存放每个子数组的start和位置
     * 排序：O(n*logn)
     * 二分查找：O(logn)
     * 遍历：O(n)
     * 因此时间复杂度：O(n*logn)
     * @param intervals
     * @return
     */
    public int[] findRightInterval2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[]{};
        }
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] res = new int[intervals.length];
        Integer[][] tmp = new Integer[intervals.length][2];
        for (int i=0; i<intervals.length; i++) {
            tmp[i] = new Integer[]{intervals[i][0], i};
        }
        Arrays.sort(tmp, Comparator.comparingInt(o -> o[0]));
        int subLen = intervals[0].length;
        for (int i = 0; i<intervals.length; i++) {
            int index = findIndex(tmp, intervals[i][subLen-1]);
            res[i] = index;
        }
        return res;
    }

    private int findIndex(Integer[][] tmp, int key) {
        int left=0, right=tmp.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (tmp[mid][0] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= tmp.length || left<0) {
            return -1;
        }
        return tmp[left][1];
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{3,4}, {2,3}, {1,2}};
        FindRightInterval436Solution solution = new FindRightInterval436Solution();
        int[] res = solution.findRightInterval2(intervals);
        System.out.println();
    }
}
