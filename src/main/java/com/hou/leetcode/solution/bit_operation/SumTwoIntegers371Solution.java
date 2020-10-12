package com.hou.leetcode.solution.bit_operation;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-30 10:12
 */
public class SumTwoIntegers371Solution {

    /**
     * a&b,可以求出哪些位需要进位，然后递归处理，直到没有进位
     * a^b，可以求出本次进位后的ans
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return (a&b)==0?(a^b):getSum(a^b, (a&b)<<1);
    }

    public static void main(String[] args) {
        SumTwoIntegers371Solution solution = new SumTwoIntegers371Solution();
        System.out.println(solution.getSum(-2, 3));
    }
}
