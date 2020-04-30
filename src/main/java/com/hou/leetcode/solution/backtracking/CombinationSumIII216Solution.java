package com.hou.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-10 12:32
 */
public class CombinationSumIII216Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        backtracking(k, 1, n, new ArrayList<>(), 0);
        return res;
    }

    private void backtracking(int k, int start, int n, List<Integer> tmp, int sum) {
        if (tmp.size() > k || sum > n) {
            return;
        }
        if (sum == n && tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=start; i<=9; i++) {
            if (sum +i > n) {
                return;
            }
            tmp.add(i);
            sum += i;
            backtracking(k, i+1, n, tmp, sum);
            tmp.remove(tmp.size()-1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSumIII216Solution().combinationSum3(3, 9);
        System.out.println();
    }
}
