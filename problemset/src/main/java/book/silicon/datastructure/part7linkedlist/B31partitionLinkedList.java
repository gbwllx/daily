package book.silicon.datastructure.part7linkedlist;

import book.silicon.datastructure.part7linkedlist.helper.ListNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/24.
 */
public class B31partitionLinkedList {
    public ListNode partitionLinkedList(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode pivot = new ListNode(x);
        ListNode first = dummy, second = pivot, cur = head;
        while (cur != null) {
            ListNode next = cur.getNext();

            if (cur.getVal() < x) {
                first.setNext(cur);
                first = cur;
            } else {
                second.setNext(cur);
                second = cur;
                second.setNext(null);
            }
            cur = next;
        }

        first.setNext(pivot.getNext());
        return dummy.getNext();
    }
}
