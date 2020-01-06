package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-01-06 11:57
 */
public class Subsets78Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(List<List<Integer>> res, int[] nums, int index, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        if (index >= nums.length){
            return;
        }
        for (int i=index; i<nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(res, nums, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets78Solution solution = new Subsets78Solution();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = solution.subsets(nums);
        System.out.println();
    }
}
