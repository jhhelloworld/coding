package leetcode;

import util.ListNode;

/**
 * jh
 * 2019年09月12日  16：22
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class Q_328_OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddHead = head.next;
        ListNode evenCur = head,oddCur = head.next;
        ListNode cur = head.next.next;
        boolean even = true;
        while (cur!=null){
            if(even){
                evenCur.next = cur;
                evenCur = evenCur.next;
            }else {
                oddCur.next = cur;
                oddCur = oddCur.next;
            }
            cur = cur.next;
            even = !even;
        }
        //注意：如果不加这行,奇数个节点会出现环：1-3-（5-2-4）-5-2-4-5-2-4
        oddCur.next = null;
        evenCur.next = oddHead;
        return head;
    }

}