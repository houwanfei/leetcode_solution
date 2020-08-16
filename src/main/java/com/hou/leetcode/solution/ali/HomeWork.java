package com.hou.leetcode.solution.ali;

import java.util.Arrays;

public class HomeWork {
    private long maxCost(int[] cost, int[] val) {
        if (cost.length == 0 || val.length==0) {
            return 0;
        }
        Arrays.sort(val);
        long sum = 0;
        int personIdx = 0;
        int workIdx = 0;
        long ans = 0;
        while (personIdx < val.length) {
            if ((workIdx == cost.length && sum<= val[personIdx])
                    || sum + cost[workIdx] > val[personIdx]) {
                ans += sum;
                personIdx++;
            } else {
                sum += cost[workIdx];
                workIdx++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
        int[] works = new int[]{3};
        int[] val = new int[]{10};
        long num = 100000*100000L;
        System.out.println(num);
        System.out.println(homeWork.maxCost(works, val));
    }
}
