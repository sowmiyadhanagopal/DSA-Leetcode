package Leetcode.LinkedList;

public class SwapNodesinPair {

        public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode second = head.next;

            ListNode remaining = swapPairs(second.next);

            second.next = first;
            first.next = remaining;

            return second;
        }
    }
