package com.hou.leetcode.solution.list;

/**
 * @auther houwanfei
 * @create 2018-09-06 下午2:39
 */
public class AddTwoNumbersSolution {
    /**
     * 劣质实现
     * l1 = 2->4->3
     * l2 = 5->6->4
     * @param l1
     * @param l2
     */
    public ListNode solution(ListNode l1, ListNode l2){
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode l3  = null;
        ListNode node3 = null;
        int scale = 0;
        while (node1 != null || node2 != null){
            if (node1 == null){
                int value = node2.val + scale;
                scale = value / 10;
                int remainder = value % 10;
                ListNode node = new ListNode(remainder);
                if (l3 == null){
                    l3 =node;
                    node3 = node;
                } else {
                    node3.next = node;
                    node3 = node;
                }
                node2 = node2.next;
                continue;
            }
            if (node2 == null){
                int value = node1.val + scale;
                scale = value / 10;
                int remainder = value % 10;
                ListNode node = new ListNode(remainder);
                if (l3 == null){
                    l3 =node;
                    node3 = node;
                } else {
                    node3.next = node;
                    node3 = node;
                }
                node1 = node1.next;
                continue;
            }
            int value = node1.val + node2.val + scale;
            scale = value / 10;
            int remainder = (value) % 10;
            ListNode node = new ListNode(remainder);
            if (l3 == null){
                l3 =node;
                node3 = node;
            } else {
                node3.next = node;
                node3 = node;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        if (scale > 0){
            ListNode node = new ListNode(scale);
            node3.next = node;
        }
        return l3;
    }

    /**
     * 优化
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solutionImprove(ListNode l1, ListNode l2){
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode l3  = new ListNode(0);
        ListNode node3 = l3;
        int scale = 0;

        while (node1 != null || node2 != null){
            if (node1 != null){
                scale += node1.val;
                node1 = node1.next;
            }

            if (node2 != null){
                scale += node2.val;
                node2 = node2.next;
            }

            node3.next = new ListNode(scale % 10);
            node3 = node3.next;
            scale /= 10;
        }
        if (scale == 1){
            node3.next = new ListNode(scale);
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode node = new ListNode(4);
        l1.next = node;
        ListNode node1 = new ListNode(3);
        node.next = node1;

        ListNode l2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        l2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;


        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
//        ListNode l3 = solution.solution(l1, l2);
        ListNode l3 = solution.solutionImprove(l1, l2);
        System.out.println();
    }
}
