package com.hou.leetcode.solution.tree;

import com.hou.leetcode.solution.util.TreeBuildUtil;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-25 18:21
 */
public class BinaryTreeZigzagLevelOrderTraversal103Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.empty()) {
            if (!stack1.isEmpty()) {
                List<Integer> subRes = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    subRes.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
                res.add(subRes);
            } else if (!stack2.empty()) {
                List<Integer> subRes = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode node = stack2.pop();
                    subRes.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
                res.add(subRes);
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, 0, root);
        return res;
    }

    private void recursion(List<List<Integer>> res, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        recursion(res, level+1, root.left);
        recursion(res, level+1, root.right);
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103Solution solution = new BinaryTreeZigzagLevelOrderTraversal103Solution();
        TreeNode head = TreeBuildUtil.buildTreeFromArray(new Integer[]{1,2,3,4,null,null,5});
        List<List<Integer>> res = solution.zigzagLevelOrder(head);
        System.out.println();
    }
}
