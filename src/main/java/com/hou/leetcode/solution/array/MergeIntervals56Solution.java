package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeIntervals56Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0]?o1[0] - o2[0] : o1[1] - o2[1]);
        List<int[]> res = new ArrayList<>();
        int[] tmp = intervals[0];
        for (int i=1; i < intervals.length; i++) {
            if (tmp[1] >= intervals[i][0]) {
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            } else {
                res.add(tmp);
                tmp = intervals[i];
            }
        }
        res.add(tmp);
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,6},{1,3},{8,10},{15,18}};
        int[][] intervals2 = new int[][]{{4,5},{1,4}};
        MergeIntervals56Solution solution = new MergeIntervals56Solution();
        int[][] res = solution.merge(intervals2);
        System.out.println();
    }
}
