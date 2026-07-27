package Leetcode.arrays;
import java.util.*;
public class MaximumProductofTwoElementsinanArray {
    class Solution {
        public int maxProduct(int[] nums) {
            int prod=0;
            int max1=Integer.MIN_VALUE;
            int max2=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                {
                    if(nums[i]>max1)
                    {
                        max2=max1;
                        max1=nums[i];
                    }
                    else if(nums[i]>max2)
                    {
                        max2=nums[i];

                    }
                }

            }
            prod=(max1-1)*(max2-1);
            return prod;
        }
    }
}
