package com.hou.leetcode.solution.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations77Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        backtracking(1, n, k, res, new ArrayList<>());
        return res;
    }

    private void backtracking(int index,int n, int k, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=index; i<=n; i++) {
            tmp.add(i);
            backtracking(i+1, n, k, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations77Solution solution = new Combinations77Solution();
        List<List<Integer>> res = solution.combine(4, 2);
        System.out.println();
    }
}
