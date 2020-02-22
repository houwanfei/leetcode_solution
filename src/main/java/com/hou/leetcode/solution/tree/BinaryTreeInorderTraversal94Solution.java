package com.hou.leetcode.solution.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left,  res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal94Solution solution = new BinaryTreeInorderTraversal94Solution();
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        List<Integer> res = solution.inorderTraversal(treeNode);
        System.out.println();
    }
}
