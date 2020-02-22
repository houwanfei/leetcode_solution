package com.hou.leetcode.solution.util;

import com.hou.leetcode.solution.list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache146Solution {
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;
        ListNode(int k, int v) { key = k;val = v; }
    }
    Map<Integer, ListNode> map;
    int capacity;
    ListNode head = null;
    ListNode tail = null;
    int size;
    public LRUCache146Solution(int capacity) {
        map = new HashMap<>();
        this.head = this.tail = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            ListNode node = map.get(key);
            if (node == tail) {
                return node.val;
            }
            if (node == head) {
                head = node.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.next = null;
            node.pre = tail;
            tail.next = node;
            tail = node;
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            node.val = value;
            if (node == tail){
                return;
            }
            if (node == head) {
                head.next.pre = null;
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        } else {
            node = new ListNode(key, value);
            if (size < capacity) {
                if (head == tail && head == null) {
                    head = node;
                } else {
                    tail.next = node;
                    node.pre = tail;
                }
            } else {
                map.remove(head.key);
                size--;
                if (head.next != null) {
                    head.next.pre = null;
                    head = head.next;
                } else {
                    head = node;
                }
                tail.next = node;
                node.pre = tail;
            }
            tail = node;
            size++;
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache146Solution solution = new LRUCache146Solution(1);
        solution.put(2, 1);
        System.out.println(solution.get(2));
        solution.put(3, 2);
        System.out.println(solution.get(2));
        System.out.println(solution.get(3));
    }
}
