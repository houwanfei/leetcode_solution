package com.hou.leetcode.solution.dp;


/**
 * @Description
 * @auther houwf
 * @create 2020-05-28 14:41
 */
public class UniqueSubstringsWraparoundString467Solution {

    /**
     * 思路：
     * 我们在手动计算 abc时，先计算 a 然后在计算ab的可能性我们只需要已b结尾的字符串加上a就可以，c同理
     * 所以abc的排列组合 a结尾 + b结尾 + c结尾
     * 题目要求的是不重复，假设开始出现已c结尾的abc，但是中间又出现bc，显然bc已经出现了在了abc中，如何去重就转化为求以c结尾最长连续
     * 最长连续字符就是以该字符结尾的排列数，因此定义一个长度为26数组，记录以每个字符结尾的排列数 最后求和便是总的不重复连续数
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        if (p == null) {
            return 0;
        }
        int[] dp = new int[26];
        int series = 0;
        for (int i=0; i<p.length(); i++) {
            if (check(p, i)) {
                series++;
            } else {
                series =1;
            }
            dp[p.charAt(i)-'a'] = Math.max(dp[p.charAt(i)-'a'], series);
        }
        int count = 0;
        for (int num : dp) {
            count += num;
        }
        return count;
    }

    private boolean check(String p, int j) {
        if (j <= 0) {
            return false;
        }
        if (p.charAt(j) == 'a' && p.charAt(j-1) == 'z') {
            return true;
        }
        return p.charAt(j) - p.charAt(j-1) == 1;
    }

    public static void main(String[] args) {
        UniqueSubstringsWraparoundString467Solution solution = new UniqueSubstringsWraparoundString467Solution();
        System.out.println(solution.findSubstringInWraproundString("zab"));
    }
}
