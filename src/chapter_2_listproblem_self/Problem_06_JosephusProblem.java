package chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月18日  20：10
 */
public class Problem_06_JosephusProblem {
    public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node josephusKill1(Node head, int m) {
        if(head == null || head.next==head || m<0){
            return head;
        }
        Node last = head;
        while (last.next!=head){
            last = last.next;
        }
        //while head!=head.next
        while (head.next!=last){
            int count = 0;
            if(++count!=m){
                last = last.next;
            }else {
                count = 0;
                last.next = head.next;
            }
            head = last.next;
        }
        return head;

    }

    public static Node josephusKill2(Node head, int m){
        return null;
    }

}