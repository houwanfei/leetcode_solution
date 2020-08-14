package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-14 13:49
 */
public class SoupServings808Solution {

    public double soupServings(int N) {
        if (N > 4800) {
            return 1;
        }
         return helper(N, N, new HashMap<>());
    }

    private double helper(int NA, int NB, Map<String, Double> memo) {
        if (NA <= 0 && NB <= 0) {
            return 0.5;
        }
        if (NA <= 0) {
            return 1.0;
        }
        if (NB <= 0) {
            return 0;
        }
        String key = NA + ":" + NB;
        if (memo.get(key) != null) {
            return memo.get(key);
        }
        double res1 = helper(NA-100, NB, memo);
        double res2 =helper(NA-75, NB-25, memo);
        double res3 =helper(NA-50, NB-50, memo);
        double res4 =helper(NA-25, NB-75, memo);
        double res = (res1 +res2 + res3 + res4)*0.25;
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        SoupServings808Solution solution = new SoupServings808Solution();
        System.out.println(solution.soupServings(1));
    }
}
