package com.hou.leetcode.solution.binary;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-17 14:28
 */
public class UglyNumberIII1201Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        long lcmAB = lcm(Math.max(a,b), Math.min(a, b));
        long lcmAC = lcm(Math.max(a,c), Math.min(a, c));
        long lcmBC = lcm(Math.max(b,c), Math.min(b, c));
        long lcmABC = lcm(Math.max(a, lcmBC), Math.min(a, lcmBC));
        while (left <= right) {
            long mid = (left + right)/2;
            long kth = mid/a+mid/b+mid/c -mid/lcmAB-mid/lcmAC-mid/lcmBC + mid/lcmABC;
            if (kth >= n) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private long lcm(long x, long y) {
        return x*y/gcm(x,y);
    }

    private long gcm(long x, long y) {
        if (y == 0) {
            return x;
        }
        while (x%y != 0) {
            long r = x%y;
            x=y;
            y=r;
        }
        return y;
    }

    public static void main(String[] args) {
        UglyNumberIII1201Solution solution = new UglyNumberIII1201Solution();
        System.out.println(solution.nthUglyNumber(5 ,2 ,3 ,3));
    }
}
