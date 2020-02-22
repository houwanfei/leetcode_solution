package com.hou.leetcode.solution.stack;

import java.util.Stack;

public class ValidParentheses20Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<chars.length; i++){
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else if (!stack.empty()){
                if (')' == chars[i] && '(' != stack.pop()) {
                    return false;
                } else if ('}' == chars[i] && '{' != stack.pop()) {
                    return false;
                } else if (']' == chars[i] && '[' != stack.pop()) {
                    return false;
                }
            } else if (stack.empty()){
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses20Solution solution = new ValidParentheses20Solution();
        System.out.println(solution.isValid("()}"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("([)]"));
    }
}
