package book.silicon.datastructure.part7linkedlist;

import book.silicon.datastructure.part7linkedlist.helper.ListNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/24.
 */
public class B32DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {return head;}
        ListNode prev = head;
        ListNode cur = head.getNext();

        while (cur != null) {
            if (cur.getVal() != prev.getVal()) {
                prev = prev.getNext();
            }
            cur = cur.getNext();
            prev.setNext(cur);
        }
        return head;
    }
}
