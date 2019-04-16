package a_test;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年04月15日  23：56
 */
public class Main {
    public static   class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        recursion (result, listNode);
        return result;

    }
    public static void recursion (ArrayList<Integer> result,ListNode listNode){
        if(listNode == null){
            return;
        }
        recursion(result,listNode.next);
        result.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        List<Integer> result = printListFromTailToHead(head);
        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i)+" ");
        }

    }


}




