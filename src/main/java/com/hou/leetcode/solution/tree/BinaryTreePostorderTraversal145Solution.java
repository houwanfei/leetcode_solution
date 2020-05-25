package com.hou.leetcode.solution.tree;

import com.hou.leetcode.solution.util.TreeBuildUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-21 11:45
 */
public class BinaryTreePostorderTraversal145Solution {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root.getLeft() != null) {
            helper(res, root.getLeft());
        }
        if (root.getRight() != null) {
            helper(res, root.getRight());
        }
        res.add(root.getVal());
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,null,2,3};
        TreeNode head = TreeBuildUtil.buildTreeFromArray(nums);
        List<Integer> res = new BinaryTreePostorderTraversal145Solution().postorderTraversal(head);
        System.out.println();
    }
}
