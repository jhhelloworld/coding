package leetcode;

import com.sun.xml.internal.bind.v2.runtime.NameBuilder;
import jdk.nashorn.internal.objects.NativeNumber;
import org.w3c.dom.ls.LSInput;
import util.ListNode;
import zcy_lesson.code_advance_08.Code_01_TopKSumCrossTwoArrays;

/**
 * jh
 * 2019年09月04日  14：49
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class Q_148_SortList {
    //思路：归并排序
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        //第一次没加head1=  head2=  第二次也忘了加
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head,head2);
    }

    //  返回中间节点的前一个 ：重点 如果只有两节点，返回第一个，防止
    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!= null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }



    public static ListNode merge(ListNode left,ListNode right){
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        while (left!=null && right!=null){
            if(left.val<right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left!=null){
            cur.next = left;
        }
        if(right!=null){
            cur.next = right;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode newHead =sortList(head);
        ListNode head2 =  getMid(head);
        System.out.println();
    }



}