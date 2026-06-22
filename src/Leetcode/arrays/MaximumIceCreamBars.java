package Leetcode.arrays;

public class MaximumIceCreamBars {

        public int maxIceCream(int[] costs, int coins) {
            int max=0;
            for(int cost:costs)
            {
                max=Math.max(max,cost);
            }
            int[] freq=new int[max+1];
            for(int cost:costs)
            {
                freq[cost]++;
            }
            int count=0;
            for(int cost=1;cost<=max;cost++)
            {
                if(freq[cost]==0)
                {
                    continue;
                }
                int canbuy=Math.min(freq[cost],coins/cost);
                count+=canbuy;
                coins-=canbuy*cost;
                if(coins<cost)
                {
                    break;
                }
            }
            return count;
        }
    }
