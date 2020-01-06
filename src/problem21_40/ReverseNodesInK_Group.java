package problem21_40;

import data_structure.ListNode;

public class ReverseNodesInK_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        return reserveSub(head, k);
    }

    private ListNode reserveSub(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode pointer = head;
        while (pointer != null && count < k - 1) {
            pointer = pointer.next;
            count++;
        }
        //剩余长度不足k 不翻转
        if (pointer == null) {
            return head;
        }
        //翻转
        ListNode nextNode = pointer.next;
        //head节点翻转后变成最后一个节点  提前保存其指针
        ListNode tail = head;
        pointer = head.next;
        //指针指向当前节点后一个  每次将指针指向节点与当前子串的head交换
        for (; count > 0; count--) {
            ListNode temp = pointer;
            pointer = pointer.next;
            tail.next = temp.next;
            temp.next = head;
            head = temp;
        }
        //对当前子串后续节点进行翻转
        tail.next = reserveSub(nextNode, k);
        return head;
    }
}
