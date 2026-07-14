package Leetcode.stack;
import java.util.*;
public class DecodeString {
    class Solution {
        public String decodeString(String s) {
            Stack<Integer>count=new Stack<>();
            Stack<StringBuilder>str=new Stack<>();
            StringBuilder currentString=new StringBuilder();
            int currentNumber=0;
            for(char ch:s.toCharArray())
            {
                if(Character.isDigit(ch))
                {
                    currentNumber=currentNumber*10+(ch-'0');

                }
                else if(ch=='[')
                {
                    count.push(currentNumber);
                    str.push(currentString);
                    currentNumber=0;
                    currentString=new StringBuilder();
                }
                else if(ch==']')
                {
                    int repeat=count.pop();
                    StringBuilder prev=str.pop();
                    for(int i=0;i<repeat;i++)
                    {
                        prev.append(currentString);
                    }
                    currentString=prev;
                }
                else
                {
                    currentString.append(ch);
                }

            }
            return currentString.toString();


        }
    }
}
