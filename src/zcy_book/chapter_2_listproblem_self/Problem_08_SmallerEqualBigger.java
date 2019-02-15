package zcy_book.chapter_2_listproblem_self;

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
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        while(head!=null){
            if(head.value < pivot){

            }
        }

        return null;

    }








































}
