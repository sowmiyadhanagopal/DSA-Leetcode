package Leetcode.stack;
import java.util.*;
public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            Stack<String>s=new Stack<>();
            String parts[]=path.split("/");
            for(String part:parts)
            {
                if(part.equals("")||part.equals("."))
                {
                    continue;
                }
                else if(part.equals(".."))
                {
                    if(!s.isEmpty())
                    {
                        s.pop();
                    }

                }
                else
                {
                    s.push(part);
                }
            }
            if(s.isEmpty())
            {
                return "/";
            }
            StringBuilder ans=new StringBuilder();
            for(String dir:s)
            {
                ans.append("/").append(dir);
            }
            return ans.toString();

        }
    }
}
