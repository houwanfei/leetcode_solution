package com.hou.leetcode.solution.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode116Solution {

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
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
