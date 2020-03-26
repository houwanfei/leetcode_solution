package com.hou.leetcode.solution.dp;

/**
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 青蛙的最后一步可能是1个台阶，也可能是两个台阶
 * @auther houwf
 * @create 2020-03-26 16:01
 */
public class JumpFloorSolution {
    public int solution(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n<=2) {
            return n;
        }
        return helper(n-1) + helper(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloorSolution().solution(4));
    }
}
