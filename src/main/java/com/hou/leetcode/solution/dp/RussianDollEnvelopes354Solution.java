package com.hou.leetcode.solution.dp;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther houwf
 * @create 2020-08-25 16:06
 */
public class RussianDollEnvelopes354Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<envelopes.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<envelopes[i].length; j++) {
                list.add(envelopes[i][j]);
            }
            lists.add(list);
        }
        lists.sort((o1, o2) -> {
            int res = o1.get(0) - o2.get(0);
            if (res != 0) {
                return res;
            }
            return o1.get(1) - o2.get(1);
        });
        int max = 1;
        int[] dp = new int[lists.size()];
        for (int i=0; i<lists.size(); i++) {
            dp[i] = 1;
            for (int j=i-1; j>=0; j--) {
                List<Integer> list = lists.get(j);
                if (list.get(0) < lists.get(i).get(0) && list.get(1) < lists.get(i).get(1)) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }



    public static void main(String[] args) {
        RussianDollEnvelopes354Solution solution = new RussianDollEnvelopes354Solution();
        int[][] envelopes = new int[][]{
                {10,8},{1,12},{6,15},{2,18},{3,19}
        };
        System.out.println(solution.maxEnvelopes(envelopes));
    }
}
