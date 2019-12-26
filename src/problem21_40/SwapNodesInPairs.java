package problem21_40;

import data_structure.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode former = null;
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while (pointer2 != null) {
            head = swapNode(head, former, pointer1, pointer2);
            //p1 p2交换位置 p1位于原p2处
            former = pointer1;
            pointer1 = pointer1.next;
            if (pointer1 == null) {
                break;
            }
            pointer2 = pointer1.next;
        }
        return head;
    }

    private ListNode swapNode(ListNode head, ListNode former, ListNode node1, ListNode node2) {
        if (former != null) {
            former.next = node2;
        } else {
            head = node2;
        }
        node1.next = node2.next;
        node2.next = node1;
        return head;
    }
}
