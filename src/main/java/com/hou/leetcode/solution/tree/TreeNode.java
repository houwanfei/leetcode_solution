package com.hou.leetcode.solution.tree;

/**
 * @Description
 * @auther houwf
 * @create 2019-12-26 17:00
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
