package com.hou.leetcode.solution.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNodeII117Solution {
    /**
     * 不满足常数空间要求
     * @param root
     * @return
     */
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
                root.right.next = next.left != null?next.left:next.right;
            }
        }

        /**
         * 这里要先计算右子树,否则，当计算10的next时，6还没和7连上导致查找到5时因为5没有子节点，查5的next为6,6未和7连接
         *                      1
         *                     / \
         *                    2   3
         *                   / \  /\
         *                   4 5  6 7
         *                  /       / \
         *                 10       8  9
         */
        connect(root.right);
        connect(root.left);
        return root;
    }

    /**
     * 思路：依然是层次遍历，如果上一层已经连接好了，可以利用上一层的关系连接下一层
     * 只需要两个变量，一个记录当前操作层的虚拟头结点（也就是该层最左边的元素），一个记录当前操作元素的前一个元素，也就是相邻左边的元素
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        Node node = root;
        Node vNode = new Node();
        Node pre;
        while (node != null) {
            vNode.next = null;
            pre = vNode;
            for (Node p = node; p != null; p = p.next) {
                if (p.left != null) {
                    pre.next = p.left;
                    pre = pre.next;
                }
                if (p.right != null) {
                    pre.next = p.right;
                    pre = pre.next;
                }
            }
            node = vNode.next;
        }
        return root;
    }
}
