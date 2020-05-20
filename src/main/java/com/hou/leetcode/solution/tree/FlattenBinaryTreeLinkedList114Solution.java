package com.hou.leetcode.solution.tree;

import com.hou.leetcode.solution.util.TreeBuildUtil;

import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-20 17:28
 */
public class FlattenBinaryTreeLinkedList114Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode res = null;
        TreeNode right = root.right;
        if (root.left != null) {
            res = helper(root.left);
            root.right = root.left;
            root.left = null;
            if (right != null) {
                res.right = right;
            } else {
                return res;
            }
        }
        return helper(right);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,5,3,4,null,6};
        TreeNode head = TreeBuildUtil.buildTreeFromArray(nums);
        FlattenBinaryTreeLinkedList114Solution solution = new FlattenBinaryTreeLinkedList114Solution();
        solution.flatten(head);
        List<Integer> res = TreeBuildUtil.buildArrayFromTree(head);
        System.out.println();
    }
}
