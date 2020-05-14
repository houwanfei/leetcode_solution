package com.hou.leetcode.solution.dp;


/**
 * 最优二叉搜索树
 *
 * 给定n个互异的关键字组成的序列K=<k1,k2,...,kn>，且关键字有序（k1<k2<...<kn），
 * 我们想从这些关键字中构造一棵二叉查找树。对每个关键字ki，一次搜索搜索到的概率为pi。
 * 可能有一些搜索的值不在K内，因此还有n+1个“虚拟键”d0,d1,...,dn，他们代表不在K内的值。
 * 具体：d0代表所有小于k1的值，dn代表所有大于kn的值。而对于i = 1,2,...,n-1,虚拟键di代表所有位于ki和ki+1之间的值。
 * 对于每个虚拟键，一次搜索对应于di的概率为qi。要使得查找一个节点的期望代价（代价可以定义为：
 * 比如从根节点到目标节点的路径上节点数目）最小，就需要建立一棵最优二叉查找树.
 *
 *
 */
public class BestBinarySearchTree {
    double[] p;
    double[] q;
    int[][] root;
    Node rt = null;

    class Node{
        String key;
        Node left;
        Node right;
        public Node(String key){
            this.key = key;
        }
    }

    public double countCost(int i, int j){
        if (j == i-1){
            return q[i-1];
        }
        double min = Double.MAX_VALUE;
        double w = q[i-1];
        for (int k=i; k<=j; k++){
            w += q[k] + p[k];
        }
        for (int r = i; r<=j; r++){
            if (countCost(i, r-1) + countCost(r+1, j) + w < min){
                min = countCost(i, r-1) + countCost(r+1, j) + w;
                root[i][j] = r;
            }
            min = Math.min(countCost(i, r-1) + countCost(r+1, j) + w, min);
        }
        return min;
    }

    public void buildTree(int i, int j, Node p, int lr){
        if (j == i-1){
            if (lr == 1){
                p.left = new Node("d" + (i-1));
                return;
            } else {
                p.right = new Node("d" + j);
                return;
            }
        }

        Node node = new Node("k" + root[i][j]);
        if (rt == null && p == null){
            p = node;
            rt = p;
        } else {
            if (lr == 1){
                p.left = node;
                p = p.left;
            } else {
                p.right = node;
                p = p.right;
            }
        }
        buildTree(i, root[i][j]-1, p, 1);
        buildTree(root[i][j]+1, j, p, 2);
    }

    public static void main(String[] args) {
        double[] q = new double[]{0.05, 0.1, 0.05, 0.05, 0.05, 0.1};
        double[] p = new double[]{0, 0.15, 0.1, 0.05, 0.1, 0.2};
        int[][] root = new int[p.length][p.length];
        BestBinarySearchTree binarySearchTree = new BestBinarySearchTree();
        binarySearchTree.p = p;
        binarySearchTree.q = q;
        binarySearchTree.root = root;

        System.out.println(binarySearchTree.countCost(1, 5));
        binarySearchTree.buildTree(1, 5, null, 0);
        System.out.println();
    }
}
