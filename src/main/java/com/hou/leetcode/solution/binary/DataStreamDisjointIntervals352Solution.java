package com.hou.leetcode.solution.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-20 18:11
 */
public class DataStreamDisjointIntervals352Solution {
    List<List<Integer>> intervals;

    /** Initialize your data structure here. */
    public DataStreamDisjointIntervals352Solution() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        if (intervals.size() == 0) {
            intervals.add(new ArrayList<Integer>(){{add(val);add(val);}});
            return;
        }
        int left=0, right=intervals.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (getIntervalEnd(mid) >= val) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (left >= intervals.size()) {
            if (intervals.get(intervals.size()-1).get(1) == (val-1)) {
                intervals.get(intervals.size()-1).set(1, val);
            } else {
                intervals.add(new ArrayList<Integer>() {{
                    add(val);
                    add(val);
                }});
            }
            return;
        }
        List<Integer> interval = intervals.get(left);
        if (interval.get(0) <= val && interval.get(1) >= val){
            return;
        }
        if (left-1 < 0) {
            if (interval.get(0) == (val+1)) {
                interval.set(0, val);
            }else {
                intervals.add(left, new ArrayList<Integer>(){{add(val);add(val);}});
            }
            return;
        }
        List<Integer> preInterval = intervals.get(left-1);
        if (interval.get(0) == (val+1) && preInterval.get(1) == (val-1)) {
            preInterval.set(1, interval.get(1));
            intervals.remove(left);
        } else if (interval.get(0) <= (val+1)) {
            interval.set(0, Math.min(interval.get(0), val));
        } else if (preInterval.get(1) >= (val-1)) {
            preInterval.set(1, Math.max(preInterval.get(1), val));
        } else {
            intervals.add(left, new ArrayList<Integer>(){{add(val);add(val);}});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        for (int i=0; i<intervals.size(); i++) {
            List<Integer> list = intervals.get(i);
            for (int j=0; j<list.size(); j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }

    private int getIntervalEnd(int i) {
        return intervals.get(i).get(1);
    }

    public static void main(String[] args) {
        DataStreamDisjointIntervals352Solution solution = new DataStreamDisjointIntervals352Solution();
        for (int i=0; i<1000; i++) {
            solution.addNum(new Random().nextInt(100));
        }
        System.out.println();
    }
}
