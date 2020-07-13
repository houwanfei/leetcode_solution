package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-13 11:54
 */
public class KthSmallestElementSortedMatrix378Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int left=matrix[0][0], right = matrix[matrix.length-1][matrix.length-1];
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(matrix, mid) >= k) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int check(int[][] matrix, int mid) {
        int i=matrix.length - 1;
        int j=0;
        int res = 0;
        while (i>=0 && j < matrix.length) {
            if (mid >= matrix[i][j]) {
                res += i+1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1,  5},
                {10, 12}
        };
        KthSmallestElementSortedMatrix378Solution solution = new KthSmallestElementSortedMatrix378Solution();
        System.out.println(solution.kthSmallest(martix, 3));
    }
}
