package problem21_40;

import data_structure.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode former = null;
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while (pointer2 != null) {
            head = swapNode(head, former, pointer1, pointer2);
            //p1 p2交换位置 p1位于原p2处
            former = pointer1;
            pointer1 = pointer1.next;
            if (pointer1 == null) {
                break;
            }
            pointer2 = pointer1.next;
        }
        return head;
    }

    private ListNode swapNode(ListNode head, ListNode former, ListNode node1, ListNode node2) {
        if (former != null) {
            former.next = node2;
        } else {
            head = node2;
        }
        node1.next = node2.next;
        node2.next = node1;
        return head;
    }

    public ListNode swapPairsV2(ListNode head) {
        // 前前节点
        ListNode prevPrevNode = null;
        // 前一个节点
        ListNode prevNode = null;
        // 新头部节点
        ListNode headNode = head;

        int index = 1;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            if (index % 2 == 0) {
                // 下标为偶数时交换
                prevNode.next = temp.next;
                temp.next = prevNode;
                if (prevPrevNode != null) {
                    prevPrevNode.next = temp;
                }
                // 交换后 前一节点往前移动一位  此时前前节点 = 原始前一节点
                prevPrevNode = prevNode;
                if (index == 2) {
                    // 第一次交换时的节点即为新头部节点
                    headNode = temp;
                }
            } else {
                // 下标为奇数
                prevNode = temp;
            }
            index++;
        }
        return headNode;
    }
}
