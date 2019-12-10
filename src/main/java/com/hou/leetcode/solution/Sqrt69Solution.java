package com.hou.leetcode.solution;

public class Sqrt69Solution {
    public int mySqrt(int x) {
        int s = 0, e = x;

        while (s < e){
            int mid = (s + e) /2;
            if (mid * mid < x) {
                if ((mid +1) * (mid +1) > x) {
                    return mid;
                } else {
                    s = mid+1;
                }
            } else if (mid * mid > x) {
                if ((mid-1) * (mid -1) < x) {
                    return mid;
                } else {
                    e = mid - 1;
                }
            } else {
                return mid;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt69Solution().mySqrt(8));
    }
}
