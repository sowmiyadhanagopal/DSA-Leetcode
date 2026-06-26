package Leetcode.stack;
import java.util.*;
public class RemovingStarsFromaString {

        public String removeStars(String s) {
            Stack<Character>st=new Stack<>();
            for(char c:s.toCharArray())
            {
                if(c!='*')
                {
                    st.push(c);
                }
                else
                {
                    st.pop();
                }
            }
            StringBuilder ans=new StringBuilder();
            for(char ch:st)
            {
                ans.append(ch);
            }
            return ans.toString();
        }
    }

