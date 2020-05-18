package com.hou.leetcode.solution.dp;

import com.hou.leetcode.solution.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 思路，和94题计算唯一二叉查找数的数目类似，
 * 我们要生成(i,j)范围内的二叉树，只需要循环将k in i-j设为根节点，然后再连接左子树(i,k-1)所有可能的根节点和(k+1, j)右子树的所有可能根节点
 * @auther houwf
 * @create 2020-05-18 12:26
 */
public class UniqueBinarySearchTreesII95Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    /**
     * 递归实现
     * @param i
     * @param j
     * @return
     */
    private List<TreeNode> helper(int i, int j) {
        if (j < i) {
            return null;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int k=i; k<=j; k++) {
            List<TreeNode> leftRes = helper(i,k-1);
            List<TreeNode> rightRes = helper(k+1, j);
            if (leftRes == null && rightRes == null) {
                res.add(new TreeNode(k, null, null));
            } else if (leftRes != null && rightRes == null) {
                for (TreeNode node : leftRes) {
                    res.add(new TreeNode(k, node, null));
                }
            } else if (leftRes == null) {
                for (TreeNode node : rightRes) {
                    res.add(new TreeNode(k, null, node));
                }
            } else {
                for (TreeNode left : leftRes) {
                    for (TreeNode right : rightRes) {
                        res.add(new TreeNode(k, left, right));
                    }
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n <= 0) {
            return null;
        }
        List<TreeNode>[][] dp = new List[n+1][n+1];
        return helperWithMemo(dp,1, n);
    }


    /**
     * 递归备忘录实现
     * @param dp
     * @param i
     * @param j
     * @return
     */
    private List<TreeNode> helperWithMemo(List<TreeNode>[][] dp, int i, int j) {
        if (j < i) {
            return new ArrayList<>();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        List<TreeNode> res = new ArrayList<>();
        for (int k=i; k<=j; k++) {
            List<TreeNode> leftRes = helperWithMemo(dp, i,k-1);
            List<TreeNode> rightRes = helperWithMemo(dp, k+1, j);
            if (leftRes.size() ==0 && rightRes.size() == 0) {
                res.add(new TreeNode(k, null, null));
            } else if (leftRes.size() > 0 && rightRes.size() == 0) {
                for (TreeNode node : leftRes) {
                    res.add(new TreeNode(k, node, null));
                }
            } else if (leftRes.size() == 0) {
                for (TreeNode node : rightRes) {
                    res.add(new TreeNode(k, null, node));
                }
            } else {
                for (TreeNode left : leftRes) {
                    for (TreeNode right : rightRes) {
                        res.add(new TreeNode(k, left, right));
                    }
                }
            }
        }
        return (dp[i][j] = res);
    }

    public static void main(String[] args) {
        List<TreeNode> res = new UniqueBinarySearchTreesII95Solution().generateTrees2(3);
        System.out.println();
    }
}
