package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-10 17:58
 */
public class CheapestFlightsWithinKStops787Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int res = helper(flights, src, dst, K, new ArrayList<>());
        return res == Integer.MAX_VALUE?-1:res;
    }

    private int helper(int[][] flights, int src, int dst, int K, List<Integer> tmp) {
        if (K == -1) {
            if (src == dst) {
                return 0;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<flights.length; i++) {
            if (flights[i][1] != dst || tmp.contains(flights[i][0])) {
                continue;
            }
            tmp.add(flights[i][0]);
            int res = helper(flights, src, flights[i][0], K-1, tmp);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(min, res+flights[i][2]);
            tmp.remove(tmp.size()-1);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0,1,100},{1,0,100},{0,2,500}
        };
        CheapestFlightsWithinKStops787Solution solution = new CheapestFlightsWithinKStops787Solution();
        System.out.println(solution.findCheapestPrice(3, nums, 0, 2, 1));
    }
}
