package Leetcode.strings;

public class ProcessStringwithSpecialOperationsI {

        public String processStr(String s) {
            StringBuilder sb=new StringBuilder();

            for(char a:s.toCharArray())
            {
                if(a>='a'&&a<='z')
                {
                    sb.append(a);
                }
                else if(a=='*')
                {
                    if(sb.length()>0)
                    {
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
                else if(a=='#')
                {
                    String temp=sb.toString();
                    sb.append(temp);
                }
            else if(a=='%')
            {
                sb.reverse();
            }
            }
            return sb.toString();

        }
    }

