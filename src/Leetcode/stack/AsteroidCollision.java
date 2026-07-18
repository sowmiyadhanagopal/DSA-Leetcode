package Leetcode.stack;
import java.util.*;
public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer>s=new Stack<>();
            for(int a:asteroids)
            {
                boolean alive=true;
                while(alive&&a<0&&!s.isEmpty()&&s.peek()>0)
                {
                    if(s.peek()<-a)
                    {
                        s.pop();


                    }
                    else if(s.peek()==-a)
                    {
                        s.pop();
                        alive=false;
                    }
                    else
                    {
                        alive=false;
                    }
                }

                if (alive) {
                    s.push(a);
                }
            }

            int[] result = new int[s.size()];
            for (int i = s.size() - 1; i >= 0; i--) {
                result[i] = s.pop();
            }

            return result;

        }
    }
}
