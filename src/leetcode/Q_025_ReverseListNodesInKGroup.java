package leetcode;

import util.ListNode;

import java.util.Stack;

/**
 * jh
 * 2019年10月29日  17：01
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 */
public class Q_025_ReverseListNodesInKGroup {
    public ListNode reverseKListNodes1(ListNode head, int K) {
        if (K < 2) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == K) {
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    //返回这一组翻转后的最后一个节点，作为下一组的pre
    public ListNode resign1(Stack<ListNode> stack, ListNode left, ListNode right) {
        ListNode cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        ListNode next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    public ListNode reverseKListNodes2(ListNode head, int K) {
        if (K < 2) {
            return head;
        }
        ListNode cur = head;
        //开始翻转的位置
        ListNode start = null;
        //当前翻转组的前一个节点
        ListNode pre = null;
        //当前翻转组的下一个节点
        ListNode next = null;
        //注意count的初始值
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                //给pre赋值，翻转之前的第一个成为下一组的前一个
                pre = start;
                count = 0;
            }
            //count++放在循环的头部还是尾部
            count++;
            //注意 cur=next 而不是 cur.next
            cur = next;
        }
        return head;
    }

    public void resign2(ListNode left, ListNode start, ListNode end, ListNode right) {
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