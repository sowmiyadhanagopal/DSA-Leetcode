package Leetcode.stack;
import java.util.*;
public class RemoveKDigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character>st=new Stack<>();
            for(char ch:num.toCharArray())
            {
                while(!st.isEmpty()&&k>0&&st.peek()>ch)
                {
                    st.pop();
                    k--;
                }
                st.push(ch);
            }
            while(k>0)
            {
                st.pop();
                k--;
            }
            StringBuilder s=new StringBuilder();
            for(char ch:st)
            {
                s.append(ch);
            }
            int i = 0;

            while (i < s.length() && s.charAt(i) == '0') {
                i++;
            }

            if (i == s.length()) {
                return "0";
            }

            return s.substring(i);
        }
    }
}
