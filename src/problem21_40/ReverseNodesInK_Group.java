package problem21_40;

import data_structure.ListNode;

public class ReverseNodesInK_Group {

    /**
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode pointer = head;
        while (pointer != null && count < k - 1) {
            pointer = pointer.next;
            count++;
        }
        //剩余长度不足k 不翻转
        if (pointer == null) {
            return head;
        }
        //翻转
        ListNode nextNode = pointer.next;
        //head节点翻转后变成最后一个节点  提前保存其指针
        ListNode tail = head;
        pointer = head.next;
        //指针指向当前节点后一个  每次将指针指向节点与当前子串的head交换
        for (; count > 0; count--) {
            ListNode temp = pointer;
            pointer = pointer.next;
            tail.next = temp.next;
            temp.next = head;
            head = temp;
        }
        //对当前子串后续节点进行翻转
        tail.next = reverseKGroup(nextNode, k);
        return head;
    }

    /**
     * 每k个翻转一次子链表
     */
    public ListNode reverseKGroupV2(ListNode head, int k) {
        // 前方第k个节点
        ListNode newHead = head;
        ListNode newTail = null;
        ListNode preKNode = head;
        int num = 1;
        while (head != null) {
            ListNode next = head.next;
            if (num % k == 0) {
                // 满足k个  进行翻转
                ListNode temp = reverseKLinkedList(preKNode, k);
                if (newHead == preKNode) {
                    // 新头部与前方第k个节点相等时则为第一次翻转链表   翻转更新头部
                    newHead = temp;
                }
                if (newTail != null) {
                    newTail.next = temp;
                }
                // 更新尾部为原始链表当前节点前方第k个节点
                newTail = preKNode;
                preKNode = next;
                newTail.next = next;
            }
            head = next;
            num++;
        }
        return newHead;
    }

    /**
     * 返回一个长度为len的翻转链表
     *
     * @param head 原始链表头部
     * @param len  需要翻转的长度
     * @return 长度为len的翻转链表
     */
    private ListNode reverseKLinkedList(ListNode head, int len) {
        // 新链表头部
        ListNode newHead = null;
        // 新链表尾部
        ListNode newTail = head;
        for (int i = 0; i < len; i++) {
            // 将后一个节点插入到新链表头部
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }


}
