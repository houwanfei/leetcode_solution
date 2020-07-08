package com.hou.leetcode.solution.sliding_window;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-07 13:39
 */
public class MaximumPointsObtainCards1423Solution {
    public int maxScore(int[] cardPoints, int k) {
        return helper(cardPoints, k, 0, cardPoints.length-1, new HashMap<>());
    }

    /**
     * 递归超时，添加备忘录 超内存
     * @param cardPoints
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int helper(int[] cardPoints, int k, int start, int end, Map<String, Integer> memo) {
        if (k == 0) {
            return 0;
        }
        String key = k +"-" + start +"-" + end;
        if (memo.get(key) != null) {
            System.out.println("hh");
            return memo.get(key);
        }
        int max = Math.max(helper(cardPoints, k-1, start+1, end, memo)+cardPoints[start],
                helper(cardPoints, k-1, start, end-1, memo)+cardPoints[end]);
        memo.put(key, max);
        return max;
    }

    /**
     * 思路：忽略取数过程，从最终结果出发思考，最终结果肯定是由两个窗口的值组成，
     * 从头出发和尾出发，窗口大小和为k，头窗口减少一个，尾窗口就会增加一个数
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore2(int[] cardPoints, int k) {
        int leftSum=0;
        int rightSum=0;
        int max = 0;
        for (int i=0; i<k; i++) {
            leftSum += cardPoints[i];
        }
        for (int i=0; i<k; i++) {
            max = Math.max(leftSum+rightSum, max);
            leftSum-=cardPoints[k-1-i];
            rightSum += cardPoints[cardPoints.length -1-i];
        }
        return Math.max(max, leftSum+rightSum);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,79,80,1,1,1,200,1};
        MaximumPointsObtainCards1423Solution solution = new MaximumPointsObtainCards1423Solution();
        System.out.println(solution.maxScore(nums, 3));
    }
}
