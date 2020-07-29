package com.hou.leetcode.solution.str;

/**
 * @Description
 * @auther houwf
 * @create 2020-07-29 13:45
 */
public class BMSolution {
    private int[] suffix(char[] chars) {
        int[] suffix = new int[chars.length];
        suffix[chars.length-1] = chars.length;
        for (int i=chars.length-2; i>=0; i--) {
            int j=chars.length-1;
            int k=i;
            while (j>=0 && k>=0 && chars[j]==chars[k]) {
                j--;
                k--;
            }
            suffix[i] = i-k;
        }
        return suffix;
    }

    private int[] goodSuffix(int[] suffix) {
        int len = suffix.length;
        int[] gs = new int[len];
        //case 3 没有后缀匹配
        for (int i=0; i<len; i++) {
            gs[i] = len;
        }
        //case 2 有匹配，但是是部分后缀匹配，这种情况前缀必须从0开始，所以suffix[i]=i+1，因为suffix[i]是以i结尾和P的公共后缀
        //从右到左，保证优先计算匹配后缀更长的，因为在用好后缀计算时是先计算长的好后缀
        int j=0;
        for (int i=len-1; i>=0; i--) {
            if (suffix[i] == i+1) {
                while (j < len-1-i) {
                    if (gs[j] == len) {
                        gs[j] = len-1-i;
                    }
                    j++;
                }
            }
        }
        //case1 有匹配，并且最长好后缀匹配，因此j的位置可以计算出 len-1-suffix[i],需要移动的长度为len-1-i
        for (int i=0; i<len-1; i++) {
            gs[len-1-suffix[i]] = len-1-i;
        }
        return gs;
    }

    private int[] badShift(char[] chars) {
        int len = chars.length;
        int[] shift = new int[256];
        for (int i=0; i<256; i++) {
            shift[i] = len;
        }
        for (int i=0; i<len; i++) {
            shift[chars[i]] = i;
        }
        return shift;
    }

    public int search(String s, String p) {
        int[] gs = goodSuffix(suffix(p.toCharArray()));
        int[] badShift = badShift(p.toCharArray());
        int i=p.length()-1;
        int j=0;
        while (i <= s.length()-p.length()) {
            i = p.length()-1;
            while (i>=0 && p.charAt(i) == s.charAt(j+i)) {
                i--;
            }
            if (i < 0) {
                return j;
            }
            j += Math.max(gs[i], i-badShift[s.charAt(i+j)]);
        }
        return -1;
    }

    public static void main(String[] args) {
        BMSolution solution = new BMSolution();
        int[] suffix = solution.suffix("bcababab".toCharArray());
        solution.goodSuffix(suffix);
        solution.badShift("bcababab".toCharArray());
        System.out.println(solution.search("adweasdababacd", "abab"));
    }
}
