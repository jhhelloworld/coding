package leetcode;

import util.ListNode;

/**
 * jh
 * 2019年10月29日  17：22
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class Q_092_reverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode left = null, begin = null, end = null, right = null;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            if (i == m - 2) {
                left = cur;
            }
            if (i == n - 1) {
                end = cur;
            }
            cur = cur.next;
        }
        //注意判空
        begin = left == null?head:left.next;
        right = end.next;
        process(left, begin, end, right);
        if (m == 1) {
            return end;
        }
        return head;


    }

    public static void process(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }

}