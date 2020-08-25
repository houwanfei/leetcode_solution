package com.hou.leetcode.solution.dp;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-24 18:39
 */
public class NumbersSameConsecutiveDifferences967Solution {
    /**
     * 从头开始构建注意两位数以上首位不能为0，
     * 每次构建个位数，个位数分为两种情况，
     * 1. 个位数last-K>=0
     * 2. 个位数last+K<=9
     * @param N
     * @param K
     * @return
     */
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            int[] res = new int[10];
            for (int i=0;i<10; i++) {
                res[i] = i;
            }
            return res;
        }
        Set<Integer> list = helper(N, K);
        int[] res = new int[list.size()];
        int i=0;
        for (Integer num : list) {
            res[i] = num;
            i++;
        }
        return res;
    }

    private Set<Integer> helper(int N, int K) {
        if (N == 1) {
            Set<Integer> list = new HashSet<>();
            for (int i=1; i<10; i++) {
                if (i+K < 10 || i-K >=0) {
                    list.add(i);
                }
            }
            return list;
        }
        Set<Integer> list = helper(N-1, K);
        Set<Integer> res = new HashSet<>();
        for (Integer num : list) {
            int last = num%10;
            if (last-K >=0) {
                res.add(num*10 + (last-K));
            }
            if (last+K <=9) {
                res.add(num*10 + (last+K));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumbersSameConsecutiveDifferences967Solution solution = new NumbersSameConsecutiveDifferences967Solution();
        int[] res = solution.numsSameConsecDiff(2, 1);
        System.out.println();
    }
}
