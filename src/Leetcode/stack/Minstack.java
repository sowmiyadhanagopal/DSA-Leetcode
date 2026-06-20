package Leetcode.stack;
import java.util.*;
public class Minstack {
    class MinStack {

        Stack<Integer>s;
        Stack<Integer>min;
        public MinStack() {
            s=new Stack<>();
            min=new Stack<>();
        }

        public void push(int value) {
            s.push(value);
            if(min.isEmpty())
            {
                min.push(value);
            }
            else
            {
                min.push(Math.min(value,min.peek()));
            }


        }

        public void pop() {
            s.pop();
            min.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min.peek();    }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
