package com.hou.leetcode.solution.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath71Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        List<String> stack = new ArrayList<>();
        for (String p: paths) {
            if ("..".equals(p) && !stack.isEmpty()) {
                stack.remove(stack.size()-1);
            } else if (!".".equals(p) && !"".equals(p) && !"..".equals(p)) {
                stack.add(p);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String str: stack) {
            sb.append(str);
            sb.append("/");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        SimplifyPath71Solution solution = new SimplifyPath71Solution();
        System.out.println(solution.simplifyPath(path));
    }
}
