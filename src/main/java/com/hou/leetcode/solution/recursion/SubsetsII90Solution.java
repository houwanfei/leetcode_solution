package com.hou.leetcode.solution.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-01-08 14:29
 */
public class SubsetsII90Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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

            while (i < nums.length-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SubsetsII90Solution solution = new SubsetsII90Solution();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = solution.subsetsWithDup(nums);
        System.out.println();
    }
}
