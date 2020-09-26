package com.hou.leetcode.solution.dfs;

import com.hou.leetcode.solution.tree.TreeNode;
import com.hou.leetcode.solution.util.TreeBuildUtil;

import java.util.HashMap;

public class HouseRobberIII337Solution {

    public int rob(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int max = dfs(root.left, false) + dfs(root.right, false);
        if (!flag) {
            max = Math.max(max, dfs(root.left, true) + dfs(root.right, true) + root.val);
        }
        return max;
    }

    /**
     * 模仿偷东西1
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        return dfs(root, new HashMap<>());
    }

    private int dfs(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.get(root) != null) {
            return memo.get(root);
        }
        int sum = 0;
        if (root.left != null) {
            sum += dfs(root.left.left, memo) + dfs(root.left.right, memo);
        }
        if (root.right != null) {
            sum += dfs(root.right.left, memo) + dfs(root.right.right, memo);
        }
        memo.put(root, Math.max(root.val+sum, dfs(root.left, memo) + dfs(root.right, memo)));
        return memo.get(root);
    }

    public static void main(String[] args) {
        HouseRobberIII337Solution solution = new HouseRobberIII337Solution();
        TreeNode treeNode = TreeBuildUtil.buildTreeFromArray(new Integer[]{3,4,5,1,3,null,1});
        System.out.println(solution.rob2(treeNode));
    }
}
