package com.hou.leetcode.solution.design;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-20 15:11
 */
public class DesignAddSearchWordsDataStructure211Solution {
    class WordNode {
        boolean wordFlag = false;
        WordNode[] next = new WordNode[26];
    }

    WordNode dict;

    /** Initialize your data structure here. */
    public DesignAddSearchWordsDataStructure211Solution() {
        dict = new WordNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        int j=0;
        WordNode curr = dict;
        while (j < chars.length) {
            if (curr.next[chars[j]-'a'] == null) {
                curr.next[chars[j]-'a'] = new WordNode();
                if (j == chars.length-1) {
                    curr.next[chars[j]-'a'].wordFlag = true;
                }
            }
            curr = curr.next[chars[j]-'a'];
            j++;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, dict);
    }

    private boolean search(char[] chars, int i, WordNode wordNode) {
        if (wordNode == null) {
            return false;
        }
        if (i == chars.length) {
            return wordNode.wordFlag;
        }
        if (chars[i] =='.') {
            for (WordNode node : wordNode.next) {
                if (search(chars, i+1, node)) {
                    return true;
                }
            }
        } else {
            return search(chars, i+1, wordNode.next[chars[i]-'a']);
        }
        return false;
    }
}
