package book.silicon.datastructure.part7linkedlist;

import book.silicon.datastructure.part7linkedlist.helper.ListNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/24.
 */
public class B30AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode iter1 = l1, iter2 = l2;
        ListNode list = null, tail = null;
        int carry = 0;
        //只要有未处理的节点或者进位不为0，循环迭代
        while (iter1 != null || iter2 != null || carry != 0) {
            int num1 = iter1 == null ? 0 : iter1.getVal();
            int num2 = iter2 == null ? 0 : iter2.getVal();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (list == null) {
                list = new ListNode(sum);
                tail = list;
            } else {
                tail.setNext(new ListNode(sum));
                tail = tail.getNext();
            }
            iter1 = iter1 == null ? null : iter1.getNext();
            iter2 = iter2 == null ? null : iter2.getNext();
        }
        return list;
    }
}
