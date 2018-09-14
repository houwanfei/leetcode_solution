package com.hou.leetcode.solution.list;

import java.util.List;

/**
 * @auther houwanfei
 * @create 2018-09-14 下午4:12
 */
public class MergeTwoSortedLists21Solution {
    public ListNode solution(ListNode l1, ListNode l2){
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode l3 = new ListNode(0);
        ListNode node3 = null;
        node3 = l3;
        while (node1 != null && node2 != null){
            if (node1.val > node2.val){
                node3.next = node2;
                node3 = node2;
                node2 = node2.next;
            } else {
                node3.next = node1;
                node3 = node1;
                node1 = node1.next;
            }
        }
        if (node1 != null){
            node3.next = node1;
        }
        if (node2 != null){
            node3.next = node2;
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node = new ListNode(2);
        l1.next = node;
        ListNode node1 = new ListNode(4);
        node.next = node1;

        ListNode l2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        l2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;

        MergeTwoSortedLists21Solution solution = new MergeTwoSortedLists21Solution();
        ListNode re = solution.solution(l1, l2);
        System.out.println("ok");
    }
}
