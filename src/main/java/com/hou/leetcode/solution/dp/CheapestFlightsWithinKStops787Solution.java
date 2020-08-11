package com.hou.leetcode.solution.dp;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-10 17:58
 */
public class CheapestFlightsWithinKStops787Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(dst);
        int res = helper(flights, src, dst, K, tmp, new HashMap<>());
        return res == Integer.MAX_VALUE?-1:res;
    }

    private int helper(int[][] flights, int src, int dst, int K, List<Integer> tmp, Map<String, Integer> memo) {
        if (src == dst) {
            return 0;
        } else if (K == -1){
            return Integer.MAX_VALUE;
        }
        String key = src +":" + dst + ":" + K;
        if (memo.get(key) != null) {
            return memo.get(key);
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<flights.length; i++) {
            if (flights[i][1] != dst || tmp.contains(flights[i][0])) {
                continue;
            }
            tmp.add(flights[i][0]);
            int res = helper(flights, src, flights[i][0], K-1, tmp, memo);
            tmp.remove(tmp.size()-1);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(min, res+flights[i][2]);
        }
        memo.put(key, min);
        return min;
    }

    public static void main(String[] args) {
        int N = 1000;
        int[][] nums = new int[N][3];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0; i<N; i++) {
            int src = random.nextInt(100);
            int dst = random.nextInt(100);
            for (int j=0; j<i; j++) {
                if (src==nums[j][0] && dst==nums[j][1]) {
                    i--;
                    continue;
                }
            }
            nums[i][0] = src;
            nums[i][1] = dst;
            nums[i][2] = random.nextInt(9999)+1;
            stringBuilder.append("[").append(nums[i][0]).append(",").append(nums[i][1]).append(",").append(nums[i][2]).append("],");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        CheapestFlightsWithinKStops787Solution solution = new CheapestFlightsWithinKStops787Solution();
        System.out.println(solution.findCheapestPrice(100, nums, 0, 66, 20));
    }
}
