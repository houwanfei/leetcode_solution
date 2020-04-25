package com.hou.leetcode.solution.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther houwf
 * @create 2020-04-23 12:24
 */
public class TopKFrequentWords692Solution {
    /**
     * 思路 hashmap来存放出现的次数，然后堆排序
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        Object[] arr = map.entrySet().toArray();
        buildHeapMax(arr);
        int len = arr.length;
        List<String> res = new ArrayList<>();
        for (int i=len-1; i>= len-k; i--) {
            res.add(((Map.Entry<String,Integer>)arr[0]).getKey());
            swap(arr, 0, i);
            helper(arr, 0, i);
        }
        return res;
    }

    private void buildHeapMax(Object[] arr) {
        for (int i=arr.length/2; i>=0; i--) {
            helper(arr, i, arr.length);
        }
    }

    private void helper(Object[] arr, int i, int len) {
        int left = 2*i +1;
        int right = 2*i+2;
        int maxIndex = i;
        if (left < len ) {
            if (((Map.Entry<String, Integer>)arr[left]).getValue() != ((Map.Entry<String, Integer>)arr[maxIndex]).getValue()) {
                if (((Map.Entry<String, Integer>)arr[left]).getValue() > ((Map.Entry<String, Integer>)arr[maxIndex]).getValue()) {
                    maxIndex = left;
                }
            } else {
                if (((Map.Entry<String, Integer>)arr[left]).getKey().compareTo(((Map.Entry<String, Integer>)arr[maxIndex]).getKey()) < 0) {
                    maxIndex = left;
                }
            }
        }
        if (right < len) {
            if (((Map.Entry<String, Integer>)arr[right]).getValue() != ((Map.Entry<String, Integer>)arr[maxIndex]).getValue()) {
                if (((Map.Entry<String, Integer>)arr[right]).getValue() > ((Map.Entry<String, Integer>)arr[maxIndex]).getValue()) {
                    maxIndex = right;
                }
            } else {
                if (((Map.Entry<String, Integer>)arr[right]).getKey().compareTo(((Map.Entry<String, Integer>)arr[maxIndex]).getKey()) < 0) {
                    maxIndex = right;
                }
            }
        }
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            helper(arr, maxIndex, len);
        }
    }

    private void swap(Object[] arr, int i, int j){
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println("i".compareTo("love"));
        List<String> res = new TopKFrequentWords692Solution().topKFrequent(words, 2);
        System.out.println();
    }
}
