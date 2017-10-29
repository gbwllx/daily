package book.silicon.datastructure.part7linkedlist;

import book.silicon.datastructure.part7linkedlist.helper.ListNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/24.
 */
public class B28ReverseList {
    /**
     * 递归写法
     */
    ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null || head.getNext() == null) {
            newHead = head;
            return head;
        }

        //递归调用
        ListNode pre = reverseList(head.getNext(), newHead);
        pre.setNext(head);
        head.setNext(null);
        return head;
    }

    /**
     * 非递归写法
     */
    ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);
        if (head == null) {return head;}
        ListNode cur = head.getNext();
        head.setNext(null);
        while (cur != null) {
            ListNode next = cur.getNext();
            cur.setNext(dummy.getNext());
            dummy.setNext(cur);
            cur.setNext(next);
        }

        return dummy.getNext();
    }
}
