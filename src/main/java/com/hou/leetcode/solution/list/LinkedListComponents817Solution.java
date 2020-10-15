package com.hou.leetcode.solution.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-14 18:08
 */
public class LinkedListComponents817Solution {
    public int numComponents(ListNode head, int[] G) {
        int len =0;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        len++;
        int[] mark = new int[len];
        for (int i=0; i<G.length; i++) {
            mark[G[i]] = 1;
        }
        int[] uf = new int[len];
        init(uf);
        node = head;
        while (node.next != null) {
            if (mark[node.val] == 1 && mark[node.next.val] == 1) {
                connect(uf, node.val, node.next.val);
            }
            node = node.next;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<uf.length; i++) {
            if (mark[i] == 1) {
                set.add(find(uf, i));
            }
        }
        return set.size();
    }

    private void init(int[] uf) {
        for (int i=0; i<uf.length; i++) {
            uf[i] = i;
        }
    }

    private void connect(int[] uf, int x, int y) {
        int i= find(uf, x);
        int j= find(uf, y);
        if (i==j) {
            return;
        }
        uf[i]=j;
    }

    private int find(int[] uf, int x) {
        while (uf[x] != x) {
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        LinkedListComponents817Solution solution = new LinkedListComponents817Solution();
        System.out.println(solution.numComponents(head, new int[]{0, 1, 3}));
    }
}
