package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-31 11:43
 */
public class MaximumStudentsTakingExam1349Solution {

    /**
     * 思路用一个整数的位标识前一排哪个位置设置了座位，每个位置可以有两种方案，因此n个座位有2^n种方案
     * 判断每一种方案是否满足条件，选择各个方案可以设置座位更多的
     * @param seats
     * @return
     */
    public int maxStudents(char[][] seats) {
        if (seats.length == 0 || seats[0].length == 0) {
            return 0;
        }
        return helper(seats, 0, 0, new int[seats.length][1 <<seats[0].length]);
    }

    private int helper(char[][] seats, int n, int bit, int[][] memo) {
        if (n==seats.length) {
            return 0;
        }
        if (memo[n][bit] > 0) {
            return memo[n][bit];
        }
        int count = 1 << seats[0].length;
        int sum = 0;
        for (int i=0; i<count; i++) {
            int tmp = check(i, bit, seats, n);
            if (tmp >= 0) {
                sum = Math.max(sum, helper(seats, n+1, i, memo)+tmp);
            }
        }
        return memo[n][bit]=sum;
    }

    private int check(int bit, int preBit, char[][] seats, int n) {
        int[] nums = new int[seats[0].length];
        int[] prevs = new int[seats[0].length];
        int num = 1;
        for (int i=0; i<seats[0].length; i++) {
            nums[i] = ((num<<i) & bit) > 0? 1:0;
            prevs[i] = ((num<<i) & preBit) > 0? 1:0;
        }
        int oneCount = 0;
        for (int i=0; i<seats[0].length; i++) {
            if (nums[i] == 1) {
                if (seats[n][i] == '#') {
                    return -1;
                }
                if (i>0 && (nums[i-1] == 1 || prevs[i-1] == 1)) {
                    return -1;
                }
                if (i<seats[0].length-1 && (nums[i+1] == 1 || prevs[i+1] == 1)) {
                    return -1;
                }
                oneCount++;
            }
        }
        return oneCount;
    }

    public static void main(String[] args) {
        char[][] seats = new char[][] {
                {'#','.','.','.','#','.','.','.'},
                {'.','#','.','#','.','#','.','#'},
                {'.','.','#','.','.','.','#','.'},
                {'.','#','.','#','.','#','.','#'},
                {'#','.','.','.','#','.','.','.'},
                {'.','.','#','.','.','.','#','.'},
                {'.','#','.','#','.','#','.','#'},
                {'#','.','.','.','#','.','.','.'}
        };
        MaximumStudentsTakingExam1349Solution solution = new MaximumStudentsTakingExam1349Solution();
        System.out.println(solution.maxStudents(seats));
    }
}
