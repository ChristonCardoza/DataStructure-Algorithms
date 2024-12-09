package StackQueue;

import java.util.Stack;



public class SQ06MinStack {

    class Pair {

        Integer first;
        Integer second;

        Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;
        }

        public String toString(){

            return "(" + first + ", " + second + ")";
        }
    }

    Stack<Pair> st  = new Stack<>();

    void push(int val) {

        if(st.isEmpty()){
            st.push(new Pair(val, val));
        } else {
            st.push(new Pair(val, Math.min(val, st.peek().second)));
        }
    }

    int getMin() {
        return st.peek().second;
    }

    int top() {
        return st.peek().first;
    }

    int pop() {
        return st.pop().first;
    }

    void printStack() {
        System.out.println(st);
    }

}


class MinStackClient {

    static class OptimizeMinStack {

        Stack<Integer> stack;
        int min;

        OptimizeMinStack() {
            stack = new Stack<>();
        }

        void push(int x) {

            if(stack.isEmpty()){
                stack.push(0); // store 0 initiallially
                min = x;
            } else {
                stack.push(x-min);

                if(x < min) {
                    min = x; // this is new minimum
                }
            }
        }

        int pop() {

            int top = stack.pop();
            int val;

            if( top <= 0) {
                val = min;
                min = min - top; // pop value it self minimum

            } else {
                val = min + top;
            }

            return val;
        }

        int top() {

            int top = stack.peek();

            if( top > 0) {
                return top + min;
            } else  {
                return min;
            }
        }

        int getMin() {
            return min;
        }
        void printStack() {
            System.out.println(stack);
        }
    }

    public static void main(String[] args) {

        System.out.println("***********************************************************************");
        System.out.println("                               Bruteforce                              ");
        System.out.println("***********************************************************************");

        SQ06MinStack minStack = new SQ06MinStack();

        minStack.push(12);
        minStack.push(15);
        minStack.push(10);

        minStack.printStack();

        System.out.println(minStack.getMin());

        minStack.pop();

        minStack.printStack();

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println("***********************************************************************");
        System.out.println("                               Optimal                                 ");
        System.out.println("***********************************************************************");

        OptimizeMinStack minStackOP = new OptimizeMinStack();

        minStackOP.push(12);
        minStackOP.push(15);
        minStackOP.push(10);

        minStackOP.printStack();

        System.out.println(minStackOP.getMin());

        minStackOP.pop();

        minStackOP.printStack();

        System.out.println(minStackOP.top());

        minStackOP.pop();

    }
}
