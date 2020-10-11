package com.hou.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement397Solution {
    public int integerReplacement(int n) {
        return helper(n, new HashMap<>());
    }

    private int helper(long n, Map<Long, Integer> memo) {
        if (n == 1) {
            return 0;
        }
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        int min = Integer.MAX_VALUE;
        if (n%2 == 0) {
            min = helper(n/2, memo)+1;
        } else {
            min = Math.min(min, helper(n-1, memo)+1);
            min = Math.min(min, helper(n+1, memo)+1);
        }
        memo.put(n, min);
        return min;
    }

    public static void main(String[] args) {
        IntegerReplacement397Solution solution = new IntegerReplacement397Solution();
        System.out.println(solution.integerReplacement(2147483647));
    }
}
