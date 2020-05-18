package com.hou.leetcode.solution.tree;

/**
 * @Description 题目：https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * @auther houwf
 * @create 2020-05-18 13:55
 */
public class SumRootLeafNumbers129Solution {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }
        curr = curr*10 + root.val;
        if (root.right == null && root.left == null) {
            return curr;
        }
        return helper(root.left, curr) + helper(root.right, curr);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(0);
//        TreeNode treeNode2 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;

        System.out.println(new SumRootLeafNumbers129Solution().sumNumbers(treeNode));
    }

}
