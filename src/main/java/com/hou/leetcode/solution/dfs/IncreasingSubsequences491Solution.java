package com.hou.leetcode.solution.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-22 14:48
 */
public class IncreasingSubsequences491Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length ==0) {
            return res;
        }
        dfs(nums, -1, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size()>1) {
            res.add(new ArrayList(tmp));
        }
        if (i >= nums.length) {
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int j=i+1; j<nums.length; j++) {
            if (used.contains(nums[j]) || (i>=0 && nums[i]>nums[j])) {
                continue;
            }
            used.add(nums[j]);
            tmp.add(nums[j]);
            dfs(nums, j, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
