public class Main {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(solution.removeNthFromEnd(head, 2));
    }
}
