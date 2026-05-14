package Leetcode.LinkedList;

public class ReverseNodesinEvenLengthGroups {


        public ListNode reverseEvenLengthGroups(ListNode head) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prevGroupEnd = dummy;
            ListNode current = head;

            int groupSize = 1;

            while (current != null) {

                int count = 0;
                ListNode temp = current;

                while (temp != null && count < groupSize) {
                    temp = temp.next;
                    count++;
                }

                if (count % 2 == 0) {

                    ListNode prev = temp;
                    ListNode node = current;

                    for (int i = 0; i < count; i++) {

                        ListNode nextNode = node.next;

                        node.next = prev;

                        prev = node;

                        node = nextNode;
                    }

                    prevGroupEnd.next = prev;

                    prevGroupEnd = current;

                    current = temp;
                }

                else {

                    for (int i = 0; i < count; i++) {
                        prevGroupEnd = current;
                        current = current.next;
                    }
                }

                groupSize++;
            }

            return dummy.next;
        }
    }
