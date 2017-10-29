package book.silicon.datastructure.part7linkedlist;

import book.silicon.datastructure.part7linkedlist.helper.ListNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/24.
 */
public class B27circleLength {
    public int getCircleLength(ListNode head) {
        ListNode slow = head;
        if (slow == null || slow.getNext() == null) {return 0;}
        ListNode fast = slow.getNext().getNext();
        //使用快慢指针
        while (fast != null && fast.getNext() != null) {
            if (slow == fast) {return getLength(slow);}
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return 0;
    }

    private int getLength(ListNode slow) {
        int length = 1;
        ListNode cur = slow;
        while (cur.getNext() != slow) {
            length++;
            cur = cur.getNext();
        }

        return length;
    }
}
