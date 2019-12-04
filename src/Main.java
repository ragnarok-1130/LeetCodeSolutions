import data_structure.ListNode;
import problem21_40.MergeTwoSortedLists;

public class Main {

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        System.out.println(solution.mergeTwoLists(l1, l2));
    }
}
