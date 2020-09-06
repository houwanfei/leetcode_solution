package com.hou.leetcode.solution.dfs;

import com.hou.leetcode.solution.tree.TreeNode;
import com.hou.leetcode.solution.util.TreeBuildUtil;


/**
 * @Description
 * @auther houwf
 * @create 2020-09-02 12:27
 */
public class BinaryTreeCameras968Solution {
    private int ans = 0;

    /**
     * DFS
     * 每个节点可能有3种状态，-1：无相机且无覆盖，0：有覆盖，1-有相机
     * 如果子节点有一个为-1，说明该节点必须为1，如果子节点有一个为1且另一个不为-1，说明该节点已被覆盖
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        int res = dfs(root);
        if (res == -1) {
            ans++;
        }
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l == -1 || r == -1) {
            ans++;
            return 1;
        }
        if (l == 1 || r == 1) {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinaryTreeCameras968Solution solution = new BinaryTreeCameras968Solution();
        Integer[] arr = new Integer[]{0};
        TreeNode root = TreeBuildUtil.buildTreeFromArray(arr);
        System.out.println(solution.minCameraCover(root));
    }
}
