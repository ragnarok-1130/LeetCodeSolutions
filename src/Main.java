import data_structure.ListNode;
import problem21_40.RemoveElement;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveElement solution = new RemoveElement();
        System.out.println(solution.removeElement(new int[]{1,1,1,2,2,3},2));
    }
}
