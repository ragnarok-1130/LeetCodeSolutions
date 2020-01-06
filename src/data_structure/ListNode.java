package data_structure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode nextNode = this.next;
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        while (nextNode != null) {
            sb.append("->").append(nextNode.val);
            nextNode = nextNode.next;
        }
        return sb.toString();
    }
}
