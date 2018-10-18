package chapter_2_listproblem_self;

import com.sun.istack.internal.localization.NullLocalizable;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/**
 * @author Jianghua
 * 2018年10月18日  19：26
 */
public class Problem_05_ReversePartList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node pre = null;
        Node pos = null;

        while (node1!=null){
            len++;
            pre = len==from-1?node1:pre;
            pos = len == to+1?node1:pos;
            node1 = node1.next;
        }

        if(from>to || from<1 || to>len){
            return head;
        }

        node1 = pre==null ? head:pre.next;
        Node node2 = node1.next;
        Node next = null;
        node1.next = pos;
        while (node2!=pos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(pre!=null){
            pre.next = node1;
            return head;
        }
        return node1;

    }

}