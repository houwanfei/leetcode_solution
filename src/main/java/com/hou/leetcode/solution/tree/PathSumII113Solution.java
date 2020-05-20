package com.hou.leetcode.solution.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-15 12:26
 */
public class PathSumII113Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode root, int sum, int curSum,List<Integer> tmp, List<List<Integer>> res) {
        if (root == null || curSum + root.val > sum) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(curSum + root.val);
            if (curSum + root.val == sum) {
                tmp.add(root.val);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);
            }
            return;
        }
        tmp.add(root.val);
        if (root.left != null) {
            helper(root.left, sum, curSum + root.val, tmp, res);
        }
        if (root.right != null) {
            helper(root.right, sum, curSum + root.val, tmp, res);
        }
        tmp.remove(tmp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);
    }
}
