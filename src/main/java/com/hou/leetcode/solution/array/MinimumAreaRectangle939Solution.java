package com.hou.leetcode.solution.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-29 10:19
 */
public class MinimumAreaRectangle939Solution {
    public int minAreaRect(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        Map<String, Boolean> x_yMap = new HashMap<>();
        for (int i=0; i<points.length; i++) {
            List<Integer> xlist = xMap.getOrDefault(points[i][0], new ArrayList<>());
            xlist.add(points[i][1]);
            xMap.put(points[i][0], xlist);
            List<Integer> ylist = yMap.getOrDefault(points[i][1], new ArrayList<>());
            ylist.add(points[i][0]);
            yMap.put(points[i][1], ylist);
            x_yMap.put(points[i][0]+":"+points[i][1], true);
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<points.length; i++) {
            List<Integer> xlist = xMap.get(points[i][0]);
            List<Integer> ylist = yMap.get(points[i][1]);
            if (xlist.size()<2 || ylist.size()<2) {
                continue;
            }
            for (Integer y : xlist) {
                for (Integer x : ylist) {
                    if (x == points[i][0] || y == points[i][1]) {
                        continue;
                    }
                    if (x_yMap.get(x + ":" + y) != null) {
                        min = Math.min(min, Math.abs(x - points[i][0])*Math.abs(y - points[i][1]));
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0,1},{3,2},{4,4},{0,2},{4,3},{2,4},{4,2},{1,1}
        };
        MinimumAreaRectangle939Solution solution = new MinimumAreaRectangle939Solution();
        System.out.println(solution.minAreaRect(points));
    }
}
