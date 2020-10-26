package com.hou.leetcode.solution.tree;



/**
 * @Description
 * @auther houwf
 * @create 2020-10-22 14:57
 */
public class CountGoodNodesBinaryTree1448Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int ans = root.val>=max?1:0;
        ans += goodNodes(root.left, Math.max(max, root.val));
        ans += goodNodes(root.right, Math.max(max, root.val));
        return ans;
    }
}
