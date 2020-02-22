package com.hou.leetcode.solution.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：转换为图，查最短路径
 */
public class WordLadder127Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        List<Integer> q = new ArrayList<>();
        wordList.add(0, beginWord);
        int[] d = new int[wordList.size()];
        d[0] = 1;
        q.add(0);
        for (int i=1; i<wordList.size(); i++) {
            d[i] = Integer.MAX_VALUE;
            q.add(i);
        }

        while (!q.isEmpty()) {
            int u = choseMin(q, d);
            for (Integer i : q){
                if (simWord(wordList.get(u), wordList.get(i)) && (d[i] == Integer.MAX_VALUE || d[i] > d[u]+1)) {
                    d[i] = d[u] + 1;
                }
            }
            if (wordList.get(u).equals(endWord)) {
                return d[u] == Integer.MAX_VALUE?0:d[u];
            }
        }
        return 0;
    }

    private boolean simWord(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diff = 0;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private int choseMin(List<Integer> q, int[] d) {
        int min = q.get(0);
        for (Integer n : q) {
            min = d[min] > d[n]?n:min;
        }
        q.remove(Integer.valueOf(min));
        return min;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","cog", "log");
        WordLadder127Solution solution = new WordLadder127Solution();
        System.out.println(solution.ladderLength("hit", "cog", new ArrayList<>(wordList)));
    }
}
