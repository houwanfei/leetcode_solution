package com.hou.leetcode.solution.util;


/**
 * @Description
 * @auther houwf
 * @create 2020-04-08 14:05
 */
public class BitOperation {
    /**
     * 计算n的二进制表示中1的个数
     * @param n
     */
    private static int countOnes(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    /**
     * 计算a，b两数和
     * 思路：&运算可以获得哪些位需要进位
     *      ^运算可以获得求和后各位的值
     *      要做的就是先求出需要进位的位，如果不为0就需要继续进位，用递归执行，直到没有进位
     *      如：11: 1011, 5: 0101
     * @param a
     * @param b
     * @return
     */
    private static int sum(int a, int b) {
        int shift = a & b;
        int sum = a^b;
        return shift == 0? sum : sum(sum, shift<<1);
    }

    /**
     * 优化，去掉局部变量
     * @param a
     * @param b
     * @return
     */
    private static int sumOptimize(int a, int b) {
        return b == 0? a : sumOptimize(a^b, (a & b)<<1);
    }

    /**
     * 给定一个长度为n的整数数组，返回缺失的一个数
     * 思路：位异或，a^b^b = a，数组值加下标运算
     * @param nums
     * @return
     */
    private static int missingNumber(int[] nums) {
        int len = nums.length;
        int xor = len;
        for (int i=0; i<len; i++) {
            xor = xor^nums[i]^i;
        }
        return xor;
    }

    private static int reverseBits(int n) {
        int mask=1,res = 0;
        for (int i=0; i<32; i++) {
            res <<= 1;
            if ((mask & n) > 0) {
                res |= 1;
            }
            mask<<=1;
        }
        return res;
    }

    /**
     * 问题：数组多数数
     * 思路：统计数组每个数的每一位，如果该位的计数大于len/2，则该位肯定是结果的位，循环统计32个位
     * @param nums
     * @return
     */
    public static int majorElement(int[] nums) {
        int count=0, mask=1, res=0;
        for (int i=0; i<32; i++) {
            count = 0;
            for (int j=0; j<nums.length; j++) {
                if ((nums[j]&mask) > 0) {
                    count++;
                }
            }
            if (count > nums.length/2) {
                res |= mask;
            }
            mask <<= 1;
        }
        return res;
    }

    /**
     * 问题：数组单个数，数组的所有数都出现3次除了一个数
     * 思路：统计数组每个数的每一位，如果该位的计数%出现的次数不等于0，则该位肯定是结果的位，循环统计32个位
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int count=0, mask=1, res=0;
        for (int i=0; i<32; i++) {
            count = 0;
            for (int j=0; j<nums.length; j++) {
                if ((nums[j]&mask) > 0) {
                    count++;
                }
            }
            if (count%3 != 0) {
                res |= mask;
            }
            mask <<= 1;
        }
        return res;
    }

    /**
     * 题目：Given a string array words, find the maximum value of length(word[i]) * length(word[j])
     * where the two words do not share common letters.
     * You may assume that each word will contain only lower case letters.
     * If no such two words exist, return 0
     *
     * 思路：将字母从0-25编号，然后将字母映射到int的位上，两个数字&运算，如果大于0则有公共字母，否则没有
     *
     * 时间复杂度：O(n^2) 空间复杂度：O(n)
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[words.length];
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                mask[i] |= (1<<(words[i].charAt(j)-'a'));
            }
            for (int j=0; j<i; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length()  * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,1,1};
//        System.out.println(missingNumber(nums));
//        System.out.println(sumOptimize(11, 3));
//        System.out.println(reverseBits(5));
        System.out.println(majorElement(nums));
//        System.out.println(singleNumber(nums));
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
//        System.out.println(maxProduct(words));
    }
}
