package Leetcode.stack;
import java.util.*;
public class RemoveOutermostParentheses {

        public String removeOuterParentheses(String s) {
            Stack<Character>st=new Stack<>();
            StringBuilder result=new StringBuilder();

            for(char c:s.toCharArray())
            {
                if(c=='(')
                {
                    if(!st.isEmpty())
                    {
                        result.append(c);
                    }
                    st.push(c);
                }
                else
                {
                    st.pop();
                    if(!st.isEmpty())
                    {
                        result.append(c);
                    }


                }
            }
            return result.toString();

        }
    }

