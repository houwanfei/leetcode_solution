package com.hou.leetcode.solution;

public class PalindromeNumber9Solution {
    public boolean solution(int num){
        if (num < 0)
            return false;
        int old = num;
        int sum = 0 ;
        while (num != 0){
            sum = sum * 10 + num % 10;
            num = num / 10;

        }
        return sum == old;
    }

    public static void main(String[] args) {
        PalindromeNumber9Solution solution = new PalindromeNumber9Solution();
        System.out.println(solution.solution(0));
    }
}
