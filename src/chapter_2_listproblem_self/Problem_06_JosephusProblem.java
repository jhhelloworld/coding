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
        int count = 0;
        while (head.next!=last){

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
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        int totol = 1;
        Node cur = head.next;
        while (cur!=head){
            totol++;
            cur = cur.next;
        }
        int n = getLive(totol,m);
        while (--n!=0){
            head = head.next;
        }
        head.next = head;

        return head;
    }

    public static int getLive(int i,int m){
        if(i==1){
            return 1;
        }
        return (getLive(i-1,m)+m)%m;
    }



    public static void printCircularList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print("Circular List: " + head.value + " ");
		Node cur = head.next;
		while (cur != head) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println("-> " + head.value);
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = head1;
		printCircularList(head1);
		head1 = josephusKill1(head1, 3);
		printCircularList(head1);

		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);
		head2.next.next.next.next.next = head2;
		printCircularList(head2);
		head2 = josephusKill2(head2, 3);
		printCircularList(head2);

	}

}