package Leetcode.LinkedList;
import java.util.*;

public class FlattenaMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    class Solution {
        public Node flatten(Node head) {
            if(head==null)
            {
                return null;
            }
            dfs(head);
            return head;
        }
        private Node dfs(Node node)
        {
            Node curr=node;
            Node last=null;
            while(curr!=null)
            {
                Node next=curr.next;
                if(curr.child!=null)
                {
                    Node childhead=curr.child;
                    Node  childtail=dfs(childhead);
                    curr.next=childhead;
                    childhead.prev=curr;
                    if (next != null) {
                        childtail.next = next;
                        next.prev = childtail;
                    }


                    curr.child = null;
                    last = childtail;
                } else {
                    last = curr;
                }

                curr = next;
            }

            return last;
        }}
}
