package com.hou.leetcode.solution.tree;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-27 16:14
 */
public class MaximumProductSplittedBinaryTree1339Solution {
    private long sum = 0;
    private long max;

    /**
     * dfs 先算出总的和
     * @param root
     * @return
     */
    public int maxProduct(TreeNode root) {
        sum = sum(root);
        splitted(root);
        long mod = (long)(Math.pow(10, 9))+7;
        return (int)(max%mod);
    }

    private long sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + sum(root.right)+root.val;
    }

    private long splitted(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long leftSum = splitted(root.left);
        long rightSum = splitted(root.right);
        max = Math.max((sum-leftSum)*leftSum, max);
        max = Math.max((sum-rightSum)*rightSum, max);
        return leftSum+rightSum+root.val;
    }
}
