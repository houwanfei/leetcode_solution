package com.hou.leetcode.solution.tree;

import com.hou.leetcode.solution.util.TreeBuildUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-25 18:21
 */
public class BinaryTreeZigzagLevelOrderTraversal103Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                List<Integer> subRes = new ArrayList<>();
                while (!stack1.empty()) {
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
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                }
                res.add(subRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103Solution solution = new BinaryTreeZigzagLevelOrderTraversal103Solution();
        TreeNode head = TreeBuildUtil.buildTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> res = solution.zigzagLevelOrder(head);
        System.out.println();
    }
}
