package com.hou.leetcode.solution.tree;



/**
 * @Description
 * @auther houwf
 * @create 2019-12-26 16:37
 */
public class ValidateBinarySearchTree98Solution {
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return this.result;
    }

    private void checkValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return;
        }
        if (node.val >min && node.val < max) {
            checkValidBST(node.left, min, node.val);
            if (result) {
                checkValidBST(node.right, node.val, max);
            }
            return;
        }
        result = false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        ValidateBinarySearchTree98Solution solution = new ValidateBinarySearchTree98Solution();
        System.out.println(solution.isValidBST(treeNode));
    }
}
