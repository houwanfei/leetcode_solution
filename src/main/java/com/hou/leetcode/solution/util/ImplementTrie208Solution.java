package com.hou.leetcode.solution.util;

/**
 * @Description
 * Trie数，前缀树
 * apple    appll   att
 *                  a
 *                 / \
 *                p   t
 *               /     \
 *              p       t
 *             /
 *            l
 *           / \
 *          e   l
 *
 * @auther houwf
 * @create 2020-06-03 9:42
 */
public class ImplementTrie208Solution {
    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie208Solution() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        char[] words = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        while (index < words.length) {
            if (node.charNodes[words[index] - 97] == null) {
                node.charNodes[words[index] - 97] = new CharNode();
            }
            CharNode charNode = node.charNodes[words[index] - 97];
            if (index+1 < words.length) {
                if (charNode.next == null) {
                    charNode.next = new TrieNode();
                }
            } else {
                charNode.isWord = true;
            }
            node = charNode.next;
            index++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        char[] words = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        while (node != null) {
            if (node.charNodes[words[index] - 97] == null) {
                return false;
            }
            if (index+1==words.length) {
                return node.charNodes[words[index] - 97].isWord;
            }
            node = node.charNodes[words[index] - 97].next;
            index++;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || "".equals(prefix)) {
            return true;
        }
        char[] words = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        while (node != null) {
            if (node.charNodes[words[index] - 97] == null) {
                return false;
            }
            if (index+1==words.length) {
                return true;
            }
            node = node.charNodes[words[index] - 97].next;
            index++;
        }
        return false;
    }

    private static class TrieNode {
        CharNode[] charNodes;

        public TrieNode() {
            charNodes = new CharNode[26];
        }
    }

    private static class CharNode {
        private boolean isWord;
        private TrieNode next;
    }

    public static void main(String[] args) {
        ImplementTrie208Solution solution = new ImplementTrie208Solution();
        solution.insert("apple");
        solution.insert("appee");
        System.out.println(solution.search("apple"));
        System.out.println(solution.search("applea"));
        System.out.println(solution.startsWith(""));
    }
}
