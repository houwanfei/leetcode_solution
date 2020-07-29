package com.hou.leetcode.solution;

public class PreimageSizeFactorialZeroesFunction793Solution {
    public int preimageSizeFZF(int K) {
        long left =4L*K,right=5L*K;
        while (left <= right) {
            long mid = (left+right)/2;
            int count = count(mid);
            if (count > K) {
                right = mid-1;
            } else if (count == K){
                return 5;
            } else {
                left = mid+1;
            }
        }
        return 0;
    }

    private int count(long mid) {
        int count=0;
        while (mid > 0) {
            count += mid/5;
            mid /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        PreimageSizeFactorialZeroesFunction793Solution solution = new PreimageSizeFactorialZeroesFunction793Solution();
        System.out.println(solution.preimageSizeFZF(1000000000));
    }
}
