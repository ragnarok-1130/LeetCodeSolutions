package problem1_20;

import data_structure.ListNode;

public class AddTwoNumbers {
    private ListNode result = null;
    private ListNode pointer = null;
    private boolean carryFlag = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val;
            ListNode resultNext;
            if (carryFlag) {
                value++;
                carryFlag = false;
            }
            resultNext = new ListNode(value % 10);
            if (value / 10 > 0) {
                carryFlag = true;
            }
            if (pointer == null) {
                result = resultNext;
                pointer = result;
            } else {
                pointer.next = resultNext;
                pointer = pointer.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = l1.val;
            if (carryFlag) {
                value++;
                carryFlag = false;
            }
            ListNode resultNext = new ListNode(value % 10);
            if (value / 10 > 0) {
                carryFlag = true;
            }
            if (pointer == null) {
                result = resultNext;
                pointer = result;
            } else {
                pointer.next = resultNext;
                pointer = pointer.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int value = l2.val;
            if (carryFlag) {
                value++;
                carryFlag = false;
            }
            ListNode resultNext = new ListNode(value % 10);
            if (value / 10 > 0) {
                carryFlag = true;
            }
            if (pointer == null) {
                result = resultNext;
                pointer = result;
            } else {
                pointer.next = resultNext;
                pointer = pointer.next;
            }
            l2 = l2.next;
        }
        if (carryFlag) {
            pointer.next = new ListNode(1);
        }
        return result;
    }
}

