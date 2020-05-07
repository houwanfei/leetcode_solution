package com.hou.leetcode.solution.dp;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-30 12:49
 */
public class CountingBits338Solution {
    /**
     * 思路 通过2^n，n代表位数表示的数来划分，自底向上从低位数字求到高位，
     * 只需要判断最后一位是否为1+i>>1的1的位数 i>>1之前已经求出
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=1; i<=num; i++) {
            System.out.println((i&1) + ":" + res[i>>1]);
            res[i] = (i&1) + res[i>>1];
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits338Solution solution = new CountingBits338Solution();
        int[] res = solution.countBits(5);
        System.out.println();
    }
}
