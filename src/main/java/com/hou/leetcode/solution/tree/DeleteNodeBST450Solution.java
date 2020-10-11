package com.hou.leetcode.solution.tree;

import com.hou.leetcode.solution.util.TreeBuildUtil;

public class DeleteNodeBST450Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.left == null && root.right == null && root.val == key)) {
            return null;
        }
        TreeNode del = search(root, key);
        if (del == null) {
            return root;
        }
        TreeNode delP = searchParent(root, del);
        if (del.left == null && del.right == null) { //没有子节点
            if (delP != null) {
                if (del.val > delP.val) {
                    delP.right = null;
                } else {
                    delP.left = null;
                }
            }
        } else if (del.left != null && del.right != null) {
            TreeNode successor = searchMin(del.right);
            TreeNode successorP = searchParent(del, successor);
            if (successor.val > successorP.val) {
                successorP.right = successor.right;
            } else {
                successorP.left = successor.right;
            }
            del.val = successor.val;
        } else {
            if (delP != null) {
                if (del.val > delP.val) {
                    delP.right = del.left == null?del.right : del.left;
                } else {
                    delP.left = del.left == null?del.right : del.left;
                }
            } else if (del == root) {
                root = del.left == null?del.right : del.left;
            }
        }
        return root;
    }

    private TreeNode search(TreeNode root, int key) {
        if (root.val == key) {
            return root;
        }
        TreeNode treeNode = null;
        if (key < root.val && root.left != null) {
            treeNode = search(root.left, key);
        }
        if (key > root.val && root.right != null) {
            treeNode = search(root.right, key);
        }
        return treeNode;
    }

    private TreeNode searchParent(TreeNode root, TreeNode search) {
        if (search.val > root.val && root.right != null) {
            if (root.right.val == search.val) {
                return root;
            } else {
                return searchParent(root.right, search);
            }
        }
        if (search.val < root.val && root.left != null) {
            if (root.left.val == search.val) {
                return root;
            } else {
                return searchParent(root.left, search);
            }
        }
        return null;
    }

    /**
     * 查询后继节点的父节点
     * @param root
     * @return
     */
    private TreeNode searchMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return searchMin(root.left);
    }

    /**
     * 递归
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode2(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode2(root.left, key);
        } else {
            if (!(root.left !=null && root.right != null)) {
                root = root.left == null?root.right : root.left;
            } else {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.val = successor.val;
                root.right = deleteNode2(root.right, successor.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuildUtil.buildTreeFromArray(new Integer[]{50,30,70,null,40,60,80});
        DeleteNodeBST450Solution solution = new DeleteNodeBST450Solution();
        solution.deleteNode2(root, 50);
        System.out.println();
    }
}
