package Leetcode.arrays;
import java.util.*;
public class SumofSubarrayMinimums {
        public int sumSubarrayMins(int[] arr) {
            int n=arr.length;
            int[] prevsmaller=new int[n];
            int[] nextsmaller=new int[n];
            Stack<Integer>stack=new Stack<>();
            for(int i=0;i<n;i++)
            {
                while(!stack.isEmpty()&&arr[stack.peek()]>arr[i])
                {
                    stack.pop();
                }
                prevsmaller[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }

                nextsmaller[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            long ans = 0;
            long mod = 1_000_000_007;

            for (int i = 0; i < n; i++) {
                long left = i - prevsmaller[i];
                long right = nextsmaller[i] - i;

                long count = left * right;

                ans = (ans + (count * arr[i]) % mod) % mod;
            }

            return (int) ans;
        }
    }



