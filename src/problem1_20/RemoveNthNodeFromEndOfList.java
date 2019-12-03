package problem1_20;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode pointer = head;
        ListNode delayedPointer = null;
        while (pointer != null) {
            pointer = pointer.next;
            i++;
            if (delayedPointer != null) {
                delayedPointer = delayedPointer.next;
            }
            if (i == n + 1) {
                //延迟n+1步  使指针指向被删除节点前一个
                delayedPointer = head;
            }
        }
        if (i == n) {
            //当被删除节点为头结点时  头结点后移
            head = head.next;
            return head;
        } else if (delayedPointer == null) {
            //即n大于链表长度时  不删除任何节点
            return head;
        }
        delayedPointer.next = delayedPointer.next.next;
        return head;
    }

}


