package com.hou.leetcode.solution.list;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-15 12:49
 */
public class ListCycleProblemSolution {

    /**
     * 问题：判断链表是否有环，如果有，返回环第一个节点
     *
     * 思路：利用快慢指针，假设起点为X，环的第一个节点Y，快慢指针在Z相遇.X->Y的距离为a，Y-Z的距离为b，Z->Y的顺时针距离为c
     * 那么到相遇时，slow指针移动的距离:a+b,fast指针移动的距离为a+b+c+b，因为2(a+b)=a+b+c+b，所以a=c
     *
     * 所以这道题解法是当相遇时，一个指针回到起点，一次移动一步，另一个指针从Z开始一次移动一步，相遇的节点就是环的第一个节点
     * @param head
     * @return
     */
    public ListNode findCycleFirstNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast.next == null || fast.next.next == null || slow.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 计算环的节点数
     * @param head
     * @return
     */
    public int countCycleNode(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        boolean meet = false;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (meet) {
                count++;
            }
            if (slow == fast) {
                if (meet) {
                    return count;
                }
                meet = true;
            }
        }
        return 0;
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
        node4.next = node3;

        ListCycleProblemSolution solution = new ListCycleProblemSolution();
//        ListNode res = solution.findCycleFirstNode(head);
        System.out.println(solution.countCycleNode(head));
        System.out.println();
    }
}
