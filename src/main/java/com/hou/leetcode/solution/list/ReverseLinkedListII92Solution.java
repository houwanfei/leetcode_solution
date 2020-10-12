package com.hou.leetcode.solution.list;

/**
 * @Description
 * @auther houwf
 * @create 2020-01-19 11:20
 */
public class ReverseLinkedListII92Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i=1;
        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode pre = null;
        ListNode headTail = null;
        ListNode tailHead = null;
        while (i <= n && curr!=null) {
            if (i==m) {
                reverseHead = curr;
                headTail = pre;
            }
            if (i==n) {
                tailHead = curr.next;
                curr.next = null;
                break;
            }
            pre = curr;
            curr = curr.next;
            i++;
        }
        ListNode newHead = reverse(reverseHead);
        if (headTail == null) {
            head = newHead;
        } else {
            headTail.next = newHead;
        }
        reverseHead.next = tailHead;
        return head;
    }

    /**
     * 递归反转
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ReverseLinkedListII92Solution solution = new ReverseLinkedListII92Solution();
        ListNode res = solution.reverseBetween(head, 1, 2);
        System.out.println();
    }
}
