package Leetcode.arrays;

public class FindthePrefixCommonArrayofTwoArrays {

        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int n=A.length;
            int[] freq=new int[n+1];
            int[] ans=new int[n];
            int c=0;
            for(int i=0;i<n;i++)
            {
                freq[A[i]]++;
                if(freq[A[i]]==2)
                {
                    c++;
                }
                freq[B[i]]++;
                if(freq[B[i]]==2)
                {
                    c++;
                }
                ans[i]=c;
            }
            return ans;
        }
    }

