package leetcode;

import util.ListNode;

/**
 * jh
 * 2019年09月05日  16：21
 *
 * 反转一个单链表。
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Q_206_ReverseLinkedList {
    //循环
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
    // 递归
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead =  reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

}