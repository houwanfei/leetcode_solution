package com.hou.leetcode.solution.bit_operation;

public class BitwiseANDNumbersRange201Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDNumbersRange201Solution().rangeBitwiseAnd(0, 1));
    }
}
