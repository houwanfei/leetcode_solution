package com.hou.leetcode.solution.dp;

import java.util.Random;

public class DecodeWaysII639Solution {
    /**
     * 递归的思想分情况
     * 1. 第i位为*
     *    1. i-1 = 1，那么1*有9种可能
     *    2. i-1 = 2,那么2*有6种可能
     *    3. i-1 = *，那么**有15种可能
     *    4. 只考虑单个数字，那么有9种可能
     * 2. 第i是小于6的数字
     *    1. i-1 <= 2，那么可以组成两位数
     *    2. i-1 = *，那么可以组成2种可能
     *    3. 只考虑单个数字，那么有1种可能
     * 3. 第i位大于6
     *    1. i-1 == 1，那么可以组成两位数
     *    2. i-1 = *，那么可以组成1种可能
     *    3. 只考虑单个数字，那么有1种可能
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        return helper(s.toCharArray(), s.length()-1, new int[s.length()]);
    }

    private int helper(char[] chars, int i, int[] memo) {
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            if (chars[i] == '*') {
                return 9;
            } else if (chars[i] == '0'){
                return 0;
            } else {
                return 1;
            }
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        int mod = (int)Math.pow(10, 9) + 7;
        int res = 0;
        if (chars[i] == '*') {
            if (chars[i-1] == '1') {
                int num = helper(chars, i-2, memo);
                for (int j=0; j<9; j++) {
                    res = (res + num)%mod;
                }
            } else if (chars[i-1] == '2') {
                int num = helper(chars, i-2, memo);
                for (int j=0; j<6; j++) {
                    res = (res + num)%mod;
                }
            } else if (chars[i-1] == '*') {
                int num = helper(chars, i-2, memo);
                for (int j=0; j<15; j++) {
                    res = (res + num)%mod;
                }
            }
            int num = helper(chars, i-1, memo);
            for (int j=0; j<9; j++) {
                res = (res + num)%mod;
            }
        } else if (chars[i] <= '6') {
            if (chars[i-1] == '1' || chars[i-1] == '2') {
                res = (res + helper(chars, i-2, memo))%mod;
            } else if (chars[i-1] == '*') {
                int num = helper(chars, i-2, memo);
                for (int j=0; j<2; j++) {
                    res = (res + num)%mod;
                }
            }
            if (chars[i] != '0') {
                res = (res + helper(chars, i - 1, memo) % mod) % mod;
            }
        } else {
            if (chars[i-1] == '1' || chars[i-1] == '*') {
                res = (res + helper(chars, i-2, memo)%mod)%mod;
            }
            res = (res + helper(chars, i-1, memo)%mod)%mod;
        }
        return memo[i]=res;
    }

    /**
     * 还可以优化空间复杂度，因为只需要用到前两个状态
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if (chars[0] == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }
        for (int i=2; i<=s.length(); i++) {
            int mod = (int)Math.pow(10, 9) + 7;
            dp[i] = 0;
            if (chars[i-1] == '*') {
                if (chars[i-2] == '1') {
                    for (int j=0; j<9; j++) {
                        dp[i] = (dp[i] + dp[i-2])%mod;
                    }
                } else if (chars[i-2] == '2') {
                    for (int j=0; j<6; j++) {
                        dp[i] = (dp[i] + dp[i-2])%mod;
                    }
                } else if (chars[i-2] == '*') {
                    for (int j=0; j<15; j++) {
                        dp[i] = (dp[i] + dp[i-2])%mod;
                    }
                }
                for (int j=0; j<9; j++) {
                    dp[i] = (dp[i] + dp[i-1])%mod;
                }
            } else if (chars[i-1] <= '6') {
                if (chars[i-2] == '1' || chars[i-2] == '2') {
                    dp[i] = (dp[i] + dp[i-2])%mod;
                } else if (chars[i-2] == '*') {
                    for (int j=0; j<2; j++) {
                        dp[i] = (dp[i] + dp[i-2])%mod;
                    }
                }
                if (chars[i-1] != '0') {
                    dp[i] = (dp[i] + dp[i - 1]) % mod;
                }
            } else {
                if (chars[i-2] == '1' || chars[i-2] == '*') {
                    dp[i] = (dp[i] + dp[i-2])%mod;
                }
                dp[i] = (dp[i] + dp[i-1])%mod;
            }
        }
        return dp[s.length()];
    }

    /**
     * 优化了空间复杂度
     * @param s
     * @return
     */
    public int numDecodings3(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int first = 1;
        int second;
        if (chars[0] == '*') {
            second = 9;
        } else {
            second = 1;
        }
        int mod = (int)Math.pow(10, 9) + 7;
        for (int i=2; i<=s.length(); i++) {
            int curr = 0;
            if (chars[i-1] == '*') {
                if (chars[i-2] == '1') {
                    for (int j=0; j<9; j++) {
                        curr = (curr + first)%mod;
                    }
                } else if (chars[i-2] == '2') {
                    for (int j=0; j<6; j++) {
                        curr = (curr + first)%mod;
                    }
                } else if (chars[i-2] == '*') {
                    for (int j=0; j<15; j++) {
                        curr = (curr + first)%mod;
                    }
                }
                for (int j=0; j<9; j++) {
                    curr = (curr + second)%mod;
                }
            } else if (chars[i-1] <= '6') {
                if (chars[i-2] == '1' || chars[i-2] == '2') {
                    curr = (curr + first)%mod;
                } else if (chars[i-2] == '*') {
                    for (int j=0; j<2; j++) {
                        curr = (curr + first)%mod;
                    }
                }
                if (chars[i-1] != '0') {
                    curr = (curr + second) % mod;
                }
            } else {
                if (chars[i-2] == '1' || chars[i-2] == '*') {
                    curr = (curr + first)%mod;
                }
                curr = (curr + second)%mod;
            }
            first = second;
            second = curr;
        }
        return second;
    }

    public static void main(String[] args) {
        DecodeWaysII639Solution solution = new DecodeWaysII639Solution();
        int N = 8000;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<N; i++) {
            int num = random.nextInt(12);
            if (num >= 10) {
                stringBuilder.append('*');
            } else {
                stringBuilder.append(num);
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println("begin:" + System.currentTimeMillis());
        System.out.println(solution.numDecodings(stringBuilder.toString()));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(solution.numDecodings2(stringBuilder.toString()));
        System.out.println("end1:" + System.currentTimeMillis());
        System.out.println(solution.numDecodings3(stringBuilder.toString()));
        System.out.println("end2:" + System.currentTimeMillis());
    }
}
