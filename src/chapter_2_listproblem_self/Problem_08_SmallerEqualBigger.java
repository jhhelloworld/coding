package chapter_2_listproblem_self;

import com.sun.xml.internal.ws.api.pipe.NextAction;
import jdk.nashorn.internal.objects.NativeNumber;

/**
 * jh
 * 2018年10月20日  22：44
 */
public class Problem_08_SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if(head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur!=null){
            i++;
            cur = cur.next;

        }
        Node[] nodeArr = new Node[i];
        cur = head;
        i=0;
        while (cur!=null){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for(i = 1;i<nodeArr.length;i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        return nodeArr[0];

    }


    public static void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index!=big){
            if(nodeArr[index].value<pivot){
                swap(nodeArr,++small,index);
            }else if(nodeArr[index].value==pivot){
                index++;
            }else {
                swap(nodeArr,index,--big);
            }

        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }


    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;

        while (head!=null){
            next = head.next;
            //todo
            head.next=null;
            if(head.value<pivot){
                if(sH ==null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }
            if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }
            if(head.value>pivot){
                if(bH==null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if(sT !=null){
            sT.next = eH;
            eT = eT == null?sT:eT;
        }

        if(eT!=null){
            eT.next = bH;
        }

        //todo
        return sH !=null? sH :eH !=null?eH :bH;




    }








































}
