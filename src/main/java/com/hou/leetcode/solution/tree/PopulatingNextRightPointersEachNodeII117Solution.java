package com.hou.leetcode.solution.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNodeII117Solution {
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        Node tail = new Node();
        queue.offer(root);
        queue.offer(tail);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (queue.peek() == tail) {
                node.next = null;
                queue.poll();
                queue.offer(tail);
            } else {
                node.next = queue.peek();
            }
        }
        return root;
    }
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                Node next = root.next;
                while (next != null && next.left == null && next.right == null) {
                    next = next.next;
                }
                if (next != null) {
                    root.left.next = next.left != null?next.left:next.right;
                }
            }
        }
        if (root.right != null) {
            Node next = root.next;
            while (next != null && next.left == null && next.right == null) {
                next = next.next;
            }
            if (next != null) {
                System.out.println("root.right:" + root.right.val + " next:" + next.val);
                root.right.next = next.left != null?next.left:next.right;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
