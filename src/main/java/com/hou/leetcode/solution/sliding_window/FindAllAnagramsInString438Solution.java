package com.hou.leetcode.solution.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 题目：给定字符串s,p，p不为空，找出p的全排列在s中出现子串的所有起始位置
 * @auther houwf
 * @create 2020-07-06 17:22
 */
public class FindAllAnagramsInString438Solution {
    /**
     * 思路和567题目一样，只是这里要求所有的情况，注意处理最后一个、s可能为空
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p.length() > s.length()) {
            return res;
        }
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];

        for (int i=0; i<p.length(); i++) {
            pCounts[p.charAt(i)-'a']++;
            sCounts[s.charAt(i)-'a']++;
        }
        for (int i=0; i<s.length()-p.length(); i++) {
            if (Arrays.equals(pCounts, sCounts)) {
                res.add(i);
            }
            sCounts[s.charAt(i)-'a']--;
            sCounts[s.charAt(i+p.length())-'a']++;
        }
        if (Arrays.equals(pCounts, sCounts)) {
            res.add(s.length()-p.length());
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString438Solution solution = new FindAllAnagramsInString438Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}
