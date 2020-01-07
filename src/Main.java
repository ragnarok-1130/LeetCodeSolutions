import data_structure.ListNode;
import problem21_40.RemoveDuplicatesFromSortedArray;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        System.out.println(solution.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
