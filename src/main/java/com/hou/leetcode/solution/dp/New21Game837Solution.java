package com.hou.leetcode.solution.dp;

/**
 * @Description
 * 思路：假设要构成5点，可以是一次5，在4的情况下抽一张1概率是P(4)/W，在3的情况下抽一下2概率P(3)/W...，因此P(5)=P(4)/W + P(3)/W + P(2)/W + P(1)/W + P(0)/W
 * 整理一下就是 P(5) = (P(4) + P(3) + P(2) + P(1) + P(0))/W 抽象一下：P(i) = sum(i-1)/w
 * 但是当点数超过W的时候变了，因为我们没法通过抽一次达到i的点数，因为没有比W大的单张牌,
 * 假设W是10，P(15) = (P(14) + P(13) + P(12) ... + P(5))/W 抽象一下：P(i) = (sum(i-1) - sum(i-W-1))
 * 然而我们忽略了当i大于K时的情况,当i大于K时，我们因为不能再抽牌，导致上面的计算方式多算了，只需要减去，怎么减呢
 * 假设K为17，N为21，W为10，很显然，最后一次的点数不能大于17因为那样的话游戏已经结束，不可能再抽牌了
 * i>K时，正确的计算：P(21) = (P(16) + P(15) ... P(9)),所以当我们计算完成时,应该减去多加的也就是P(17)-P(20), (sum(20)-sum(16))
 * 创建一个dp数组代表 sum(i)，注意sum(i)不是概率是一个累加概率
 * @auther houwf
 * @create 2020-05-13 13:49
 */
public class New21Game837Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K+W) {
            return 1;
        }
        double[] dp = new double[K+W];
        dp[0] = 1;
        for (int i=1; i<K+W; i++) {
            dp[i] = dp[i-1];
            if (i <= W) {
                dp[i] += dp[i-1]/W;
            } else {
                dp[i] += (dp[i-1] - dp[i-W-1])/W;
            }
            if (i > K) {
                dp[i] -= (dp[i-1] - dp[K-1])/W;
            }
        }
        return dp[N] - dp[K-1];
    }

    public static void main(String[] args) {
        System.out.println(new New21Game837Solution().new21Game(6, 1, 10));
    }
}
