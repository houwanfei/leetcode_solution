package com.hou.leetcode.solution.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-06-17 9:38
 */
public class RestoreIPAddresses93Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) {
            return res;
        }
        backtracking(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(String s, int index, List<String> tmp, List<String> res) {
        if (tmp.size() == 4) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String str:tmp) {
                    sb.append(str).append(".");
                }
                res.add(sb.substring(0, sb.length()-1));
            }
            return;
        }
        for (int i=index+1; i<=s.length(); i++) {
            String subIp = s.substring(index,i);
            if (subIp.length() >1 && subIp.startsWith("0")) {
                return;
            }
            if (subIp.length() > 3 || Integer.valueOf(subIp) > 255){
                continue;
            }
            tmp.add(subIp);
            backtracking(s, i, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new RestoreIPAddresses93Solution().restoreIpAddresses("25502");
        System.out.println();
    }
}
