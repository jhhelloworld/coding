package leetcode;

import util.ListNode;

import java.util.List;

/**
 * jh
 * 2019年08月16日  00：15
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 1-2-3-4-5  2
 * 如果删掉的是头节点
 */
public class Q_019_RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //找到前面节点
        ListNode fast = head;
        for(int i= 0;i<n-1;i++){
            if(fast!=null){
                fast = fast.next;
            }else {
                return head;
            }
        }
        //记录slow节点，以及slow的前一个节点
        ListNode slow = head;
        ListNode pre =null;
        while (fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(pre == null){
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        removeNthFromEnd(head,2);
        System.out.println();

    }

}