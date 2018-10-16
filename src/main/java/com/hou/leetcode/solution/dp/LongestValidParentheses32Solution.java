package com.hou.leetcode.solution.dp;

import java.util.Stack;

public class LongestValidParentheses32Solution {
    public int solution(String s){
        if (s == null || s.length() == 0)
            return 0;
        char[] sc = s.toCharArray();
        int[] dp = new int[sc.length +1];
        int max = 0;
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<=sc.length; i++){
            if (sc[i-1] == '('){
                dp[i] = 0;
            } else {

            }
        }

        max = dp[0];
        for (int i=0; i<=sc.length; i++){
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int solution2(String s){
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        char[] sc = s.toCharArray();

        for (int i=0; i<sc.length; i++){
            if (sc[i] == '('){
                stack.push(i);
            } else {
                if (!stack.empty()){
                    dp[stack.pop()] = 1;
                    dp[i] = 1;
                }
            }
        }

        int max = 0;
        int sum = 0;
        for (int i=0; i< sc.length; i++){
            if (dp[i] == 0){
                max = Math.max(max, sum);
                sum = 0;
            } else {
                sum += dp[i];
            }
        }
        max = Math.max(max, sum);
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses32Solution solution = new LongestValidParentheses32Solution();
        System.out.println(solution.solution2(")()())"));
    }
}
