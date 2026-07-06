package Leetcode.stack;
import java.util.*;
public class FinalPricesWithaSpecialDiscountinaShop {

        public int[] finalPrices(int[] prices) {
            int n=prices.length;
            int[] result=prices.clone();
            Stack<Integer>st=new Stack<>();
            for(int i=0;i<n;i++)
            {
                while(!st.isEmpty()&&prices[i]<=prices[st.peek()])
                {
                    int index=st.pop();
                    result[index]=prices[index]-prices[i];
                }
                st.push(i);
            }
            return result;
        }
    }
