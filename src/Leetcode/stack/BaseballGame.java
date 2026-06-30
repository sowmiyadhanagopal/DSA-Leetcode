package Leetcode.stack;
import java.util.*;
public class BaseballGame {

        public int calPoints(String[] operations) {
            Stack<Integer>s=new Stack<>();
            for(String o:operations)
            {
                if (o.equals("+")) {
                    int top = s.pop();
                    int newtop = top + s.peek();
                    s.push(top);
                    s.push(newtop);
                }
                else  if(o.equals("C"))
                {
                    s.pop();
                }
                else if(o.equals("D"))
                {
                    s.push(2*s.peek());
                }
                else {
                    s.push(Integer.valueOf(o));
                }

            }
            int ans=0;
            for(int r:s)
            {
                ans+=r;
            }
            return ans;
        }
    }
