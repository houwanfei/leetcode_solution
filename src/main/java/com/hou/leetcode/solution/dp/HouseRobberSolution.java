package com.hou.leetcode.solution.dp;

/**
 * @auther houwanfei
 * @create 2018-09-06 下午1:39
 */
public class HouseRobberSolution {

    public int solution(int[] moneys){
        if (moneys == null || moneys.length ==0){
            return 0;
        }
        int preTwo = 0;
        int pre = 0;
        for (int i=0; i<moneys.length; i++) {
            int tmp = preTwo + moneys[i];
            preTwo = pre;
            pre = Math.max(tmp, pre);
        }
        return Math.max(preTwo, pre);
    }

    public static void main(String[] args) {
        int[] moneys = {2, 7, 9, 3, 1};
        HouseRobberSolution solution = new HouseRobberSolution();
        System.out.println(solution.solution(moneys));
    }
}
