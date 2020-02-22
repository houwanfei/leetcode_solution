package com.hou.leetcode.solution.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-19 12:04
 */
public class Permutations46Solution {
    private List<List<Integer>> res = null;
    private List<Integer> used = null;
    private int[] nums = null;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        res = new ArrayList<>();
        this.nums = nums;
        this.used = new ArrayList<>();
        backtracking(new ArrayList<>());
        return res;
    }

    private void backtracking(List<Integer> result) {
        if (result.size() == nums.length) {
            res.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            result.add(nums[i]);
            used.add(nums[i]);
            backtracking(result);
            result.remove(result.size()-1);
            used.remove(used.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permutations46Solution solution = new Permutations46Solution();
        List<List<Integer>> res = solution.permute(nums);
        System.out.println();
    }
}
