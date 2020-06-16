package com.hou.leetcode.solution.util;

public class CacheTest {
    public static void main(String[] args) {
        int[][] nums = new int[10000000][16];
        for (int i=0; i<10000000; i++) {
            for (int j=0; j<16; j++) {
                nums[i][j] = i+j;
            }
        }
        System.out.println(System.currentTimeMillis());
        sum1(nums, 10000000, 16);
//        sum2(nums, 10000000, 16);
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 缓存命中低
     * @param nums
     * @param row
     * @param col
     * @return
     */
    private static int sum1(int[][] nums, int row, int col) {
        int sum = 0;
        for (int j=0; j<col; j++) {
            for (int i=0; i<row; i++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }

    /**
     * 缓存命中高
     * @param nums
     * @param row
     * @param col
     * @return
     */
    private static int sum2(int[][] nums, int row, int col) {
        int sum = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }
}
