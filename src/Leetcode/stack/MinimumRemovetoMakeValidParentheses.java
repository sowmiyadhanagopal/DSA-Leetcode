package Leetcode.stack;
import java.util.*;
public class MinimumRemovetoMakeValidParentheses {

        public String minRemoveToMakeValid(String s) {
            Stack<Integer>st=new Stack<>();
            boolean remove[]=new boolean[s.length()];
            for(int i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                if(c=='(')
                {
                    st.push(i);
                }
                else if(c==')')
                {
                    if(!st.isEmpty())
                    {
                        st.pop();
                    }
                    else
                    {
                        remove[i]=true;
                    }
                }
            }
            while(!st.isEmpty())
            {
                remove[st.pop()]=true;
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                if(!remove[i])
                {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }

    }
