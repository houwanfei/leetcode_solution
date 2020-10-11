package com.hou.leetcode.solution.dfs;

import java.util.Stack;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-27 16:01
 */
public class DecodeString394Solution {
    public String decodeString(String s) {
        return dfs(s);
    }

    /**
     * 深度优先搜索 递归生成子串
     * @param s
     * @return
     */
    private String dfs(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i=0;
        while (i < s.length()) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                stringBuilder.append(s.charAt(i));
                i++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder count = new StringBuilder();
                count.append(s.charAt(i));
                i++;
                while (i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count.append(s.charAt(i));
                    i++;
                }
                Stack<Integer> stack = new Stack<>();
                StringBuilder subStr = new StringBuilder();
                if (i<s.length() && s.charAt(i) == '[') {
                    stack.push(i);
                    i++;
                }
                while (i<s.length() && !stack.isEmpty()) {
                    if (s.charAt(i) == '[') {
                        stack.push(i);
                    }
                    if (s.charAt(i) == ']') {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        subStr.append(s.charAt(i));
                    }
                    i++;
                }
                String res = dfs(subStr.toString());
                if ("".equals(res)) {
                    continue;
                }
                for (int j=0; j<Integer.valueOf(count.toString()); j++) {
                    stringBuilder.append(res);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeString394Solution solution = new DecodeString394Solution();
        System.out.println(solution.decodeString("3[a]2[b4[F]c]"));
    }
}
