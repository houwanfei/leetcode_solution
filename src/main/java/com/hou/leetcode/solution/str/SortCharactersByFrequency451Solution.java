package com.hou.leetcode.solution.str;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-20 14:26
 */
public class SortCharactersByFrequency451Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[256];
        for (int i=0; i<s.length(); i++) {
            count[(int)s.charAt(i)]++;
        }
        int[] ids = new int[256];
        for (int i=0; i<ids.length;i++) {
            ids[i] = i;
        }
        //build heap
        for (int i=(count.length-1)/2; i>=0; i--) {
            sink(count, ids, i, count.length);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=count.length-1; i>=0; i--) {
            while(count[0] > 0) {
                sb.append((char)ids[0]);
                count[0]--;
            }
            swap(count, ids, 0, i);
            sink(count, ids, 0, i);
        }
        return sb.toString();
    }

    private void sink(int[] count, int[] ids, int i, int len) {
        while (i < len) {
            int son = 2 * (i+1) - 1;
            if (son >= len) {
                break;
            }
            if (son+1<len && count[son] < count[son+1]) {
                son++;
            }
            if (count[son] < count[i]) {
                break;
            }
            swap(count, ids, i, son);
            i = son;
        }
    }

    private void swap(int[] count, int[] ids, int i, int j) {
        int tmpcount = count[i];
        int tmpids = ids[i];
        count[i] = count[j];
        ids[i] = ids[j];
        count[j] = tmpcount;
        ids[j] = tmpids;
    }

    public static void main(String[] args) {
        SortCharactersByFrequency451Solution solution = new SortCharactersByFrequency451Solution();
        System.out.println(solution.frequencySort("aacccd"));
    }
}
