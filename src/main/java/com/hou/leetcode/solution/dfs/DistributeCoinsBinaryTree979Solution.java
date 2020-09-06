package com.hou.leetcode.solution.dfs;

import com.hou.leetcode.solution.tree.TreeNode;
import com.hou.leetcode.solution.util.TreeBuildUtil;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-02 15:27
 */
public class DistributeCoinsBinaryTree979Solution {
    int ans = 0;

    /**
     * dfs
     * 定义如果子树需要coin，那就返回负数，如果有多余的coin返回正数
     * 因此该节点处移动的次数 Math.abs(l) + Math.abs(r)
     * 该节点之后需要的coin为 l+r+root.val-1
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans += Math.abs(l) + Math.abs(r);
        return l+r+root.val-1;
    }

    public static void main(String[] args) {
        DistributeCoinsBinaryTree979Solution solution = new DistributeCoinsBinaryTree979Solution();
        Integer[] arr = new Integer[]{1,0,1,null,3,0};
        TreeNode root = TreeBuildUtil.buildTreeFromArray(arr);
        System.out.println(solution.distributeCoins(root));
    }
}
