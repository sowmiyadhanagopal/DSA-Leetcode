package Leetcode.strings;

public class JumpGameVII {

        public boolean canReach(String s, int minJump, int maxJump) {
            int n=s.length();
            boolean[] reachable=new boolean[n];
            reachable[0]=true;
            int reachablecount=0;
            for(int i=1;i<n;i++)
            {
                if(i-minJump>=0 && reachable[i-minJump])
                {
                    reachablecount++;
                }
                if(i-maxJump-1>=0 && reachable[i-maxJump-1])
                {
                    reachablecount--;
                }
                if(s.charAt(i)=='0'&& reachablecount>0)
                {
                    reachable[i]=true;
                }
            }
            return reachable[n-1];
        }
    }

