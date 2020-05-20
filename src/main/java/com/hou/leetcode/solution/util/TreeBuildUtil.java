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

    public static String buildArrayFromTree(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        list.add(head.getVal());
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.getLeft() == null && node.getRight() == null) {
                continue;
            }
            if (node.getLeft() == null) {
                list.add(null);
            } else {
                queue.offer(node.getLeft());
                list.add(node.getLeft().getVal());
            }
            if (node.getRight() == null) {
                list.add(null);
            } else {
                queue.offer(node.getRight());
                list.add(node.getRight().getVal());
            }
        }
        StringBuilder sb =new StringBuilder();
        sb.append("[");
        for (int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size()-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
