package problem21_40;

import data_structure.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
