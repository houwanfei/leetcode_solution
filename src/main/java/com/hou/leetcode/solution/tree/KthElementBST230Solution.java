package com.hou.leetcode.solution.tree;

import java.util.Stack;

public class KthElementBST230Solution {
    private int currK;
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return res;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node.left != null) {
            inorderTraversal(node.left, k);
        }
        currK++;
        if (currK == k) {
            res = node.val;
        }
        if (node.right != null) {
            inorderTraversal(node.right, k);
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode1.right = treeNode3;
        treeNode.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;
        System.out.println(new KthElementBST230Solution().kthSmallest2(treeNode, 1));
    }
}
