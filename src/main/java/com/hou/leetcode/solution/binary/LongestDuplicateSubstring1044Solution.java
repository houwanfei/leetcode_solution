package com.hou.leetcode.solution.binary;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-27 18:21
 */
public class LongestDuplicateSubstring1044Solution {
    public String longestDupSubstring(String S) {
        int left=1, right=S.length()-1;
        char[] chars = S.toCharArray();
        String ans = "";
        long mod = (long) (Math.pow(10,9)+7);
        while (left <= right) {
            int mid = (left + right)/2;
            long pow = 1;
            for (int i=0; i<mid-1; i++) {
                pow = (pow*26)%mod;
            }
            long p = hash(chars, mid, 0, 0, 0, pow);
            Map<Long, Integer> map = new HashMap<>();
            map.put(p, 0);
            long h = p;
            boolean exist = false;
            for (int i=1; i<=chars.length-mid; i++) {
                h = hash(chars, mid, i, 1, h, pow);
                if (map.containsKey(h) && check(chars, map.get(h), i, mid)) {
                    exist = true;
                    ans = ans.length() < mid? S.substring(i, i+mid):ans;
                    break;
                }
                map.put(h, i);
            }
            if (exist) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return ans;
    }

    private long hash(char[] chars, int len, int i, int flag, long hash, long pow) {
        long mod = (long) (Math.pow(10,9)+7);
        int range = 26;
        if (flag == 0) {
            for (int j=i; j<len;j++) {
                hash = (hash*range+chars[j]-'a') % mod;
            }
        } else {
            hash = (range*(hash - (chars[i-1]-'a')*pow)+chars[i+len-1]-'a')%mod;
            if (hash < 0) {
                hash = (hash+mod);
            }
        }
        return hash;
    }

    private boolean check(char[] chars, int i, int j, int len) {
        for (int k=0; k<len; k++) {
            if (chars[i+k] != chars[j+k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestDuplicateSubstring1044Solution solution = new LongestDuplicateSubstring1044Solution();
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int j=0; j<100; j++) {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                stringBuilder.append((char) (97 + random.nextInt(26)));
            }
//        System.out.println(stringBuilder.toString());
            String res = solution.longestDupSubstring(stringBuilder.toString());
//            System.out.println(solution.longestDupSubstring(stringBuilder.toString()));
            list.add(res.length());
        }
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println();
    }
}
