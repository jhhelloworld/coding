package leetcode;

import util.ListNode;

/**
 * jh
 * 2020年01月04日  12：28
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Q_002_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int value = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            cur.next = new ListNode(value % 10);
            carry = value/10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            cur = cur.next;
        }
        return dummyHead.next;
    }

}