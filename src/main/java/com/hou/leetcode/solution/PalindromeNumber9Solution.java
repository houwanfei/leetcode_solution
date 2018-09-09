package com.hou.leetcode.solution;

public class PalindromeNumber9Solution {
    /**
     * 判断数字是否回文数字
     *
     * 思路 将数字反转后比较大小是否相等
     * @param num
     * @return
     */
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
