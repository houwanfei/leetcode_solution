package com.hou.leetcode.solution.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39Solution {
    List<List<Integer>> res = null;
    int target = 0;
    int[] candidates = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.target = target;
        this.candidates = candidates;
        combinationSum(candidates, new ArrayList<>(), 0, 0);
        return res;
    }

    private void combinationSum(int[] candidates, List<Integer> result, int currSum, int index) {
        if (currSum > target) {
            return;
        }
        if (currSum == target) {
            res.add(new ArrayList<>(result));
            return;
        }
        for (int i=index; i< candidates.length; i++) {
            result.add(candidates[i]);
            combinationSum(candidates, result, currSum+candidates[i], i);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        CombinationSum39Solution solution = new CombinationSum39Solution();
        List<List<Integer>> res = solution.combinationSum(candidates, 8);
        System.out.println();

    }
}
