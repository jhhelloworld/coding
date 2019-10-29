package util;


/**
 * jh
 * 2019年08月10日  13：18
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }



    public  ListNode generateList(String s){
        String[] strings = s.split(",");
        if(strings.length == 0){
            return null;
        }
        ListNode head = new ListNode(Integer.valueOf(strings[0]));
        ListNode cur = head;
        for(int i = 1;i<strings.length ;i++){
            cur.next = new ListNode(Integer.valueOf(strings[i]));
            cur = cur.next;
        }
        return head;
    }


    public  void  printList(ListNode head){
        while (head!= null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }




}