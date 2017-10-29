package book.silicon.datastructure.part7linkedlist;

import book.silicon.datastructure.part7linkedlist.helper.ListNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/23.
 */
public class B26mergeTwoLists {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                cur.setNext(l1);
                l1 = l1.getNext();
            } else {
                cur.setNext(l2);
                l2 = l2.getNext();
            }
            cur = cur.getNext();
        }

        if (l1 != null) {
            cur.setNext(l1);
        } else if (l2 != null) {
            cur.setNext(l2);
        }

        return dummy.getNext();
    }
}
