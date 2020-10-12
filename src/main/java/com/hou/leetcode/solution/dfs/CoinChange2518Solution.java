package com.hou.leetcode.solution.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description
 * @auther houwf
 * @create 2020-09-30 10:39
 */
public class CoinChange2518Solution {

    /**
     * 递归+备忘录实现，要注意避免重复计算，所以用j表示每次计算开始
     *
     * 还有种思路，多重背包
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[][] memo = new int[amount+1][coins.length];
        for (int i=0; i<=amount; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(amount, coins, 0, memo);
    }

    private int dfs(int amount, int[] coins, int j, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (amount < coins[0]) {
            return 0;
        }
        if (memo[amount][j] != -1) {
            return memo[amount][j];
        }
        int sum = 0;
        for (int i=j; i<coins.length; i++) {
            sum += dfs(amount-coins[i], coins, i, memo);
        }
        return memo[amount][j] = sum;
    }

    public static void main(String[] args) {
        CoinChange2518Solution solution = new CoinChange2518Solution();
//        int[] coins = new int[]{1, 2, 5};
        int M = 500;
        int[] coins = new int[M];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Random random = new Random();
        int max = 5000;
        Set<Integer> set = new HashSet<>();
        int i=0;
        while (set.size() < M) {
            int num = random.nextInt(max)+1;
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            coins[i] = num;
            stringBuilder.append(coins[i]);
            if (i<M-1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        System.out.println(solution.change(5000, coins));
    }
}
