package com.hou.leetcode.solution.list;

/**
 * @Description
 * @auther houwf
 * @create 2020-10-20 13:42
 */
public class MergeKSortLists23Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode ans = new ListNode(0);
        ListNode last = null;
        int len = lists.length;
        int j=0;
        while (j<len) {
            while (lists[j] == null && len>j) {
                swap(lists, j, len-1);
                len--;
            }
            j++;
        }
        for (int i=(len-1)/2; i>=0; i--) {
            sink(lists, i, len);
        }

        for (int i=len-1; i>=0; i--) {
            while (lists[0] != null) {
                ListNode min = lists[0];
                if (ans.next == null) {
                    ans.next = min;
                    last = min;
                } else {
                    last.next = min;
                    last = last.next;
                }
                lists[0] = min.next;
                if (lists[0] != null) {
                    sink(lists, 0, i+1);
                }
            }
            swap(lists, 0, i);
            sink(lists, 0, i);
        }

        return ans.next;
    }

    private void sink(ListNode[] lists, int i, int len) {
        while (i < len) {
            int son = 2*(i+1)-1;
            if (son >= len ) {
                break;
            }
            if (son+1 < len && lists[son].val > lists[son+1].val) {
                son++;
            }
            if (lists[son].val >= lists[i].val) {
                break;
            }
            swap(lists, i, son);
            i = son;
        }
    }

    private void swap(ListNode[] lists, int i, int j) {
        ListNode node = lists[i];
        lists[i] = lists[j];
        lists[j] = node;
    }
}
