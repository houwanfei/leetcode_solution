package com.hou.leetcode.solution;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-17 12:51
 */
public class Pow50Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x*x, n/2);
        }
        return myPow(x*x, n/2)*x;
    }

    public static void main(String[] args) {
        System.out.println(new Pow50Solution().myPow(2.00000, -2));
    }
}
