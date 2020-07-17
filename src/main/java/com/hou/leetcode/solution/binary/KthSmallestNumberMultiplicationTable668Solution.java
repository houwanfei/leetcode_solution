package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-14 12:33
 */
public class KthSmallestNumberMultiplicationTable668Solution {
    /**
     * 和378类似
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(m,n,mid) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int check(int m, int n, int mid) {
        int count = 0;
        int i=m, j=1;
        while (i>=1 && j<=n) {
            if (i*j <= mid) {
                count += i;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestNumberMultiplicationTable668Solution().findKthNumber(30000, 30000, 145667));
    }
}
