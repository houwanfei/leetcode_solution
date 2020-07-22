package com.hou.leetcode.solution.dp;

import java.util.*;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-21 14:48
 */
public class MaximumProfitJobScheduling1235Solution {
    /**
     * 动态规划 计算以i时间结尾时最优利益，如果没有以i结尾的工作区间，dp[i]=dp[i-1]
     * 结合hashmap来记录以i时间结尾的下标，避免内层循环遍历
     *
     * 占用空间高 取决于最大endtime
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int end = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<endTime.length; i++) {
            end = Math.max(end, endTime[i]);
            List<Integer> list = map.getOrDefault(endTime[i], new ArrayList<>());
            list.add(i);
            map.put(endTime[i], list);
        }
        int[] dp = new int[end+1];
        dp[0] = 0;
        for (int i=1; i<=end; i++) {
            dp[i] = dp[i-1];
            List<Integer> list = map.get(i);
            if (list == null || list.size() == 0){
                continue;
            }
            for (Integer index : list) {
                dp[i] = Math.max(dp[i], dp[startTime[index]]+profit[index]);
            }
        }
        return dp[end];
    }

    /**
     * dp 以考虑第i份工作前的最大收益
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[profit.length][3];
        for (int i=0; i<profit.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        //以endtime从小到大排序
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));
        int[] dp = new int[profit.length];
        dp[0] = jobs[0][2];
        for (int i=1; i<jobs.length; i++) {
            int left=0,right=i-1;
            while (left <= right) {
                int mid = (left+right)/2;
                if (jobs[mid][1] >jobs[i][0]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            if (right >= 0 && jobs[right][1] <= jobs[i][0]) {
                dp[i] = Math.max(dp[i-1], dp[right] + jobs[i][2]);
            } else {
                dp[i] = Math.max(dp[i-1], jobs[i][2]);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        //startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
        int[] startTime = new int[]{1,2,3,3};
        int[] endTime = new int[]{3,4,5,6};
        int[] profit = new int[]{50,10,40,70};
        MaximumProfitJobScheduling1235Solution solution = new MaximumProfitJobScheduling1235Solution();
        System.out.println(solution.jobScheduling2(startTime, endTime, profit));
    }
}
