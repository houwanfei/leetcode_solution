package com.hou.leetcode.solution.util;

import com.hou.leetcode.solution.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @auther houwf
 * @create 2020-05-20 17:59
 */
public class TreeBuildUtil {
    public static TreeNode buildTreeFromArray(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (i < nums.length) {
            TreeNode node = queue.poll();
            if (nums[i] != null) {
                TreeNode left = new TreeNode(nums[i]);
                node.setLeft(left);
                queue.offer(left);
            }
            if (i+1 < nums.length && nums[i+1] != null) {
                TreeNode right = new TreeNode(nums[i+1]);
                node.setRight(right);
                queue.offer(right);
            }
            i = i+2;
        }
        return head;
    }

    public static Integer[] buildArrayFromTree(TreeNode head) {
        List<Integer> nums = new ArrayList<>();
        helper(nums, head, 0);
        return nums;
    }

    private static void helper(List<Integer> nums, TreeNode node, int index) {
        nums[index] = node.getVal();
        if (node.getLeft() != null) {
            helper(nums, node.getLeft(), 2*index+1);
        }
        if (node.getRight() != null) {
            helper(nums, node.getRight(), 2*index+2);
        }
    }
}
