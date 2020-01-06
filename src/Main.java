import data_structure.ListNode;
import problem21_40.ReverseNodesInK_Group;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseNodesInK_Group solution = new ReverseNodesInK_Group();
        System.out.println(solution.reverseKGroup(head, 3));
    }
}
