package com.hou.leetcode.solution.dp;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-17 17:44
 */
public class MinimumCostCutStick1547Solution {
    public int minCost(int n, int[] cuts) {
        return helper(0, n, cuts, new HashMap<>());
    }

    private int helper(int start, int end, int[] cuts, Map<String, Integer> memo) {
        int min = Integer.MAX_VALUE;
        String key = start + ":" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int cut : cuts) {
            if (cut <= start || cut >= end) {
                continue;
            }
            int res1 = helper(start, cut, cuts, memo);
            int res2 = helper(cut, end, cuts, memo);
            min = Math.min(min, res1+res2+(end-start));
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        memo.put(key, min);
        return min;
    }

    /**
     * 递归思想
     * 一个小技巧，将cuts先排序，然后对cuts加一个起点和终点，可以避免每次遍历所有的cuts
     * @param n
     * @param cuts
     * @return
     */
    public int minCost2(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] points = new int[cuts.length+2];
        System.arraycopy(cuts, 0,points, 1,cuts.length);
        points[0] = 0;
        points[points.length-1] = n;
        return helper(0, points.length-1, points, new int[points.length][points.length]);
    }

    private int helper(int start, int end, int[] points, int[][] memo) {
        if (start+1 >= end) {
            return 0;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i=start+1; i < end; i++) {
            int res1 = helper(start, i, points, memo);
            int res2 = helper(i, end, points, memo);

            min = Math.min(min, res1+res2 + (points[end]-points[start]));
        }
        return memo[start][end] = min;
    }

    public static void main(String[] args) {
        int N = 100;
        int[] cuts = new int[N];
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            int r = random.nextInt(1000000-1)+1;
            while (set.contains(r)) {
                r = random.nextInt(1000000-1)+1;
            }
            set.add(r);
            cuts[i] = r;
            stringBuilder.append(cuts[i]);
            if (i < N-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        MinimumCostCutStick1547Solution solution = new MinimumCostCutStick1547Solution();
        System.out.println(System.currentTimeMillis());
        System.out.println(solution.minCost(1000000, cuts));
        System.out.println(System.currentTimeMillis());
        System.out.println(solution.minCost2(1000000, cuts));
        System.out.println(System.currentTimeMillis());
    }
}
