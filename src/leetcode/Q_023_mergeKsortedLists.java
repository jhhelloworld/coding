package leetcode;

import util.ListNode;

import javax.swing.event.HyperlinkEvent;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * jh
 * 2019年08月17日  14：00
 */
public class Q_023_mergeKsortedLists {
    //初始思路，每次遍历头结点，找到最小值， 每次找最小节点需要耗时o(n)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int curMinIndex = fingSmallestHead(lists);
        ListNode newHead = null;
        ListNode cur = null;
        while (curMinIndex != -1) {
            if (newHead == null) {
                newHead = lists[curMinIndex];
                cur = newHead;
            } else {
                cur.next = lists[curMinIndex];
                cur = cur.next;
            }
            lists[curMinIndex] = lists[curMinIndex].next;
            curMinIndex = fingSmallestHead(lists);

        }
        return newHead;
    }


    private int fingSmallestHead(ListNode[] lists) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                result = i;
            }
        }
        return result;
    }


    //使用优先队列存储每个链表的头节点，相对于第一种的优势在于：查找最小头结点的时间复杂度降为o(logN)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });


        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            cur.next = min;
            cur = min;

            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return head.next;

    }


    //利用归并的思想，每两个链表合并，最终合并成一个大链表
    //优势：不用维度优先队列，查找最小头节点，另外合并链表可及时终止
    public static ListNode mergeKLists3(ListNode[] lists) {
        return mL(lists, 0, lists.length - 1);
    }

    private static ListNode mL(ListNode[] lists, int low, int high) {
        if (high < low) {
            return null;
        }
        if (high == low) {
            return lists[low];
        }

        int mid = (low + high) / 2;
        ListNode a = mL(lists, low, mid);
        ListNode b = mL(lists, mid + 1, high);
        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        } else {
            cur.next = b;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[5];
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);


        listNodes[0] = head1;
        listNodes[1] = head2;
        listNodes[2] = head3;
        listNodes[3] = head4;
        listNodes[4] = head5;
        mergeKLists3(listNodes);


    }


}