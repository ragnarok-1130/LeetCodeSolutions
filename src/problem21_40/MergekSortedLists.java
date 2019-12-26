package problem21_40;

import data_structure.ListNode;

public class MergekSortedLists {

    //二分法 O(mlogn)
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        ListNode l1 = partition(lists, start, start + (end - start) / 2);
        ListNode l2 = partition(lists, start + (end - start) / 2 + 1, end);
        return mergeTwoSortedList(l1, l2);
    }

    //O(n·m)
    public ListNode mergeKListsV1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoSortedList(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pointer = null;
        //是否头部节点
        boolean isFirst = true;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (isFirst) {
                    isFirst = false;
                    head = l1;
                    pointer = head;
                } else {
                    pointer.next = l1;
                    pointer = pointer.next;
                }
                l1 = l1.next;
            } else {
                if (isFirst) {
                    isFirst = false;
                    head = l2;
                    pointer = head;
                } else {
                    pointer.next = l2;
                    pointer = pointer.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return head;
    }
}
