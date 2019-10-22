package leetcode;

import jdk.nashorn.internal.objects.NativeNumber;
import util.ListNode;
import util.TreeNode;

/**
 * jh
 * 2019年09月04日  23：04
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 这两个链表不相交，因此返回 null。
 */
public class Q_160_IntersectionOfTwoLinkedLists {

    /**
     * 思路：两次遍历
     * 第一次遍历，统计两个链表的长度 长度差为 n
     * 第二次遍历，长链表向前走n 步，两个链表同时前，有相等的节点为相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        //curA 为较短的
        curA = lenA < lenB ? headA : headB;
        curB = curA == headA ? headB : headA;

        int diff = Math.abs(lenA - lenB);
        while (diff != 0) {
            curB = curB.next;
            diff--;
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;


    }


    //大神做法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(null==null);
    }
}





















