package Leetcode.LinkedList;

public class MaximumTwinSumofaLinkedList {

        public int pairSum(ListNode head) {

            ListNode slow=head;
            ListNode fast=head;
            while(fast!=null&&fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode prev = null;
            ListNode curr=slow;
            while(curr!=null)
            {
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode first=head;
            ListNode second=prev;
            int ans=Integer.MIN_VALUE;
            while(second!=null)
            {
                ans=Math.max(first.val+second.val,ans);
                first=first.next;
                second=second.next;
            }
            return ans;
        }
    }

