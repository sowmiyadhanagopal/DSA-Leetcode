package Leetcode.dp;

public class TotalWavinessofNumbersinRangeI {

        public int totalWaviness(int num1, int num2) {
            int ans=0;
            for(int num=num1;num<=num2;num++)
            {
                ans+=waviness(num);
            }
            return ans;
        }
        private int waviness(int num)
        {
            String s=String.valueOf(num);
            int count=0;
            int n=s.length();
            if(n<3) return 0;
            for(int i=1;i<n-1;i++)
            {
                int left=s.charAt(i-1)-'0';
                int mid=s.charAt(i)-'0';
                int right=s.charAt(i+1)-'0';
                if((mid>left&&mid>right)||(mid<left&&mid<right))
                {
                    count++;
                }

            }
            return count;
        }
    }

