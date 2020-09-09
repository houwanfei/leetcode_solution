package com.hou.leetcode.solution.weekly;


public class AvoidConsecutiveRepeatingCharactersSolution {
    public String modifyString(String s) {
        return dfs(s, new StringBuilder(), 0, 0);
    }

    private String dfs(String s, StringBuilder sb, int pre, int i) {
        if (i == s.length()) {
            return sb.toString();
        }

        if (s.charAt(i) == '?') {
            for (int j=97; j<123; j++) {
                if (j == pre) {
                    continue;
                }
                sb.append((char)j);
                String res = dfs(s, sb, j,i+1);
                if (res != null) {
                    return res;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        } else {
            if ((int)s.charAt(i) == pre) {
                return null;
            }
            sb.append(s.charAt(i));
            return dfs(s, sb, (int)s.charAt(i), i+1);
        }
        return null;
    }

    public static void main(String[] args) {
        AvoidConsecutiveRepeatingCharactersSolution solution = new AvoidConsecutiveRepeatingCharactersSolution();
        System.out.println(solution.modifyString("??yw?ipkj?"));
    }
}
