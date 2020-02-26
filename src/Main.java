import data_structure.ListNode;
import problem21_40.Implement_strStr;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Implement_strStr solution = new Implement_strStr();
        System.out.println(solution.strStr("aabaaabaaac","aabaaac"));
    }
}
