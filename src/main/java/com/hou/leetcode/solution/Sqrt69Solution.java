package com.hou.leetcode.solution;

public class Sqrt69Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int s = 0, e = x;

        while (s < e){
            int mid = s + (e-s) /2;
            if (x/mid == mid) {
                return mid;
            } else if (x/mid > mid) {
                s = mid+1;
            } else {
                e = mid;
            }
        }
        return s-1;
    }

    public static void main(String[] args) {
//        System.out.println(new Sqrt69Solution().mySqrt(2147395599));
        System.out.println(new Sqrt69Solution().mySqrt(2));
    }
}
