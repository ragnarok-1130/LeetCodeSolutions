import data_structure.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            if (map.get(head) != null) {
                return head;
            }
            map.put(head, i++);
            head = head.next;
        }
        return null;
    }

    /**
     * 使用set稍微提高性能
     */
    public ListNode detectCycleV1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        int i = 0;
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }


    /**
     * 经典方法：快慢指针
     * 数学证明: https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle
     */
    public ListNode detectCycleV2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 存在环
                slow = head;
                // fast = fast;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
