package com.hou.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-26 18:25
 */
public class MostFrequentSubtreeSum508Solution {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        int[] arr = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = helper(root.left, map) + helper(root.right, map) + root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }
}
