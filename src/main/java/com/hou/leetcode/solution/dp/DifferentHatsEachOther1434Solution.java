package com.hou.leetcode.solution.dp;

import java.util.*;

public class DifferentHatsEachOther1434Solution {
    public int numberWays(List<List<Integer>> hats) {
        return helper(hats, 0, new HashSet<>(), new HashMap<>());
    }

    private int helper(List<List<Integer>> hats, int i,Set<Integer> used, Map<String, Integer> memo) {
        if (i == hats.size()) {
            return 1;
        }
        StringBuilder key = new StringBuilder();
        for (int j=0; j<=40; j++) {
            if (used.contains(j)) {
                key.append("1");
            } else {
                key.append("0");
            }
        }
        key.append(":").append(i);
        if (memo.get(key.toString()) != null) {
            System.out.println("dp");
            return memo.get(key.toString());
        }
        int res = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        List<Integer> list = hats.get(i);
        for (Integer index : list) {
            if (used.contains(index)) {
                continue;
            }
            used.add(index);
            res = (res + helper(hats, i+1, used, memo))%mod;
            used.remove(index);
        }
        memo.put(key.toString(), res);
        return res;
    }

    public int numberWays2(List<List<Integer>> hats) {
        List<Integer>[] cache = new List[41];
        for (int i=0; i<cache.length; i++) {
            cache[i] = new ArrayList<>();
        }
        for (int i=0; i<hats.size(); i++) {
            List<Integer> hat = hats.get(i);
            for (Integer hatIndex : hat) {
                cache[hatIndex].add(i);
            }
        }
        int[][] dp = new int[41][1<<hats.size()];
        return 0;
    }

    public static void main(String[] args) {
        DifferentHatsEachOther1434Solution solution = new DifferentHatsEachOther1434Solution();
        List<List<Integer>> hats = new ArrayList<>();
        hats.add(Arrays.asList(1,2,4,6,7,8,9,11,12,13,14,15,16,18,19,20,23,24,25));
        hats.add(Arrays.asList(2,5,16));
        hats.add(Arrays.asList(1,4,5,6,7,8,9,12,15,16,17,19,21,22,24,25));
        hats.add(Arrays.asList(1,3,6,8,11,12,13,16,17,19,20,22,24,25));
        hats.add(Arrays.asList(11,12,14,16,18,24));
        hats.add(Arrays.asList(2,3,4,5,7,8,13,14,15,17,18,21,24));
        hats.add(Arrays.asList(1,2,6,7,10,11,13,14,16,18,19,21,23));
        hats.add(Arrays.asList(1,3,6,7,8,9,10,11,12,14,15,16,18,20,21,22,23,24,25));
        hats.add(Arrays.asList(2,3,4,6,7,10,12,14,15,16,17,21,22,23,24,25));
//        hats.add(Arrays.asList(2,15,17,23));
        System.out.println(solution.numberWays(hats));
    }
}
