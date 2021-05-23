import data_structure.ListNode;

import java.util.HashMap;
import java.util.Map;

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
}
