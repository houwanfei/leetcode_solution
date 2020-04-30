package com.hou.leetcode.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-25 18:17
 */
public class PermutationsII47Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new ArrayList<>(), new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> tmp, List<Integer> assList) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        List<Integer> currList = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (assList.contains(i) || currList.contains(nums[i])) {
                continue;
            }
            currList.add(nums[i]);
            assList.add(i);
            tmp.add(nums[i]);
            backtracking(nums, res, tmp, assList);
            assList.remove(assList.size()-1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        PermutationsII47Solution solution = new PermutationsII47Solution();
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println();
    }
}
