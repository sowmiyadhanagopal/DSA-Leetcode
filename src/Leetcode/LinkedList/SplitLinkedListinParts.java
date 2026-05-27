package Leetcode.LinkedList;

public class SplitLinkedListinParts {

        public ListNode[] splitListToParts(ListNode head, int k) {
            int l=0;
            ListNode temp=head;
            while(temp!=null)
            {
                l++;
                temp=temp.next;
            }
            int basesize=l/k;
            int extra=l%k;
            ListNode[] result=new ListNode[k];
            ListNode curr=head;
            for(int i=0;i<k;i++)
            {
                result[i]=curr;
                int currsize=basesize;
                if(extra>0)
                {
                    currsize++;
                    extra--;
                }
                for(int j=1;j<currsize;j++)
                {
                    if(curr!=null)
                    {
                        curr=curr.next;
                    }
                }
                if(curr!=null)
                {
                    ListNode nextpart=curr.next;
                    curr.next=null;
                    curr=nextpart;
                }
            }
            return result;
        }
    }

