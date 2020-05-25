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
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack2 = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty() || !stack2.empty()) {
            if (!queue.isEmpty()) {
                List<Integer> subRes = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
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
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(subRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103Solution solution = new BinaryTreeZigzagLevelOrderTraversal103Solution();
        TreeNode head = TreeBuildUtil.buildTreeFromArray(new Integer[]{1,2,3,4,null,null,5});
        List<List<Integer>> res = solution.zigzagLevelOrder(head);
        System.out.println();
    }
}
