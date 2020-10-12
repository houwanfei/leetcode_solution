package com.hou.leetcode.solution.backtracking;


public class BeautifulArrangement526Solution {
    /**
     * 思想：回溯
     * @param N
     * @return
     */
    public int countArrangement(int N) {
        return backtracking(N, 1, new boolean[N+1]);
    }

    private int backtracking(int N, int i, boolean[] used) {
        if (i == N+1) {
            return 1;
        }
        int ans = 0;
        for (int j=1; j<=N; j++) {
            if ((i%j != 0 && j%i != 0) || used[j]) {
                continue;
            }
            used[j] = true;
            ans += backtracking(N, i+1, used);
            used[j] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArrangement526Solution solution = new BeautifulArrangement526Solution();
        System.out.println(solution.countArrangement(15));
    }
}
