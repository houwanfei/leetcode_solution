package com.hou.leetcode.solution.concrete_math;

/**
 * 约瑟夫问题
 * J(1) = 1
 * J(2n) = 2J(n)-1 奇数
 * J(2n+1) = 2J(n)+1 偶数
 * 奇数时
 */
public class JosephusProblem {
    public int solution(int n) {
        if (n==1) {
            return 1;
        }
        if (n%2 == 0) {
            return 2*solution(n/2)-1;
        }
        return 2*solution(n/2) + 1;
    }

    public static void main(String[] args) {
        JosephusProblem josephusProblem = new JosephusProblem();
        System.out.println(josephusProblem.solution(20));
    }
}
