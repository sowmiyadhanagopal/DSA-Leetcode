package Leetcode.arrays;

public class Best_Time_To_Buy_and_Sell_Stock {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for (int price : prices) {

                if (price < minPrice) {
                    minPrice = price;
                }

                int profit = price - minPrice;

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
            return maxProfit;

        }
    }

