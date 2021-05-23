import data_structure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    /**
     * 加入set操作耗时较长且占用额外的存储空间
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 经典方法： 快慢指针
     */
    public boolean hasCycleV2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
