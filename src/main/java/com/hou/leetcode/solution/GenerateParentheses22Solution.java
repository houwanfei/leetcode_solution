package com.hou.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22Solution {
    List<String> resList = null;
    public List<String> generateParenthesis(int n) {
        resList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        generate(n,sb,0,0);
        return resList;
    }

    private void generate(int n, StringBuffer sb, int left, int right) {
        if (left == n && right == n) {
            resList.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            generate(n, sb, left+1, right);
            sb.setLength(sb.length()-1);
        }

        if (right < left) {
            sb.append(")");
            generate(n, sb, left, right+1);
            sb.setLength(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses22Solution solution = new GenerateParentheses22Solution();
        List<String> res = solution.generateParenthesis(3);
        res.forEach(System.out::println);
    }
}
