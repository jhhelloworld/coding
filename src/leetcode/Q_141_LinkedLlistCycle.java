package leetcode;

import util.ListNode;

import java.util.List;

/**
 * jh
 * 2019年09月04日  13：39
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 */
public class Q_141_LinkedLlistCycle {

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head,fast = head;
        while (fast!=null&& fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;


    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        System.out.println(hasCycle(l));

    }


}