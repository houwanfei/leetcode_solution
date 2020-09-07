package com.hou.leetcode.solution.dp;

import java.util.Arrays;
import java.util.Random;

public class CountAllPossibleRoutes1575Solution {
    /**
     * 思想：递归+备忘录
     * 要求start-finish的种数，可以转换为start-k-finish，k代表0个或多个
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] memo = new int[locations.length][fuel+1];
        for (int i=0; i<locations.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(locations, start, finish, fuel, memo);
    }

    private int helper(int[] locations, int start, int finish,int fuel, int[][] memo) {
        if (fuel < 0) {
            return 0;
        }
        int res = 0;
        int mod = (int)(Math.pow(10, 9) + 7);
        if (finish == start) {
            res = (res+1)%mod;
        }
        if (memo[finish][fuel] != -1) {
            return memo[finish][fuel];
        }
        for (int i=0; i<locations.length; i++) {
            if (i == finish) {
                continue;
            }
            res = (res + helper(locations, start, i, fuel - Math.abs(locations[finish]-locations[i]), memo))%mod;
        }
        return memo[finish][fuel]= res;
    }

    public static void main(String[] args) {
        CountAllPossibleRoutes1575Solution solution = new CountAllPossibleRoutes1575Solution();
//        int[] locations = new int[]{1,2,3};
        int N = 100;
        int[] locations = new int[N];
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append("[");
        for (int i=0; i<N; i++) {
            locations[i] = random.nextInt((int)(Math.pow(10, 9) + 1));
            sb.append(locations[i]);
            if (i < locations.length-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.countRoutes(locations, 0, 0, 200));
        System.out.println("end:" + System.currentTimeMillis());
    }
}
