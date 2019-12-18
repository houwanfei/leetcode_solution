package com.hou.leetcode.solution.array;

import java.util.*;

public class CombinationSumII40Solution {
    HashSet<List<Integer>> res = null;
    int target = 0;
    int[] candidates = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.res = new HashSet<>();
        this.target = target;
        this.candidates = candidates;
        combinationSum(candidates, new ArrayList<>(), 0, 0);
        return new ArrayList<>(res);
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
            combinationSum(candidates, result, currSum+candidates[i], i+1);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        CombinationSumII40Solution solution = new CombinationSumII40Solution();
        List<List<Integer>> res = solution.combinationSum(candidates, 8);
        System.out.println();

    }
}
