package StackQueue;

import java.util.Stack;

public class SQ07MaxStack {

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
            st.push(new Pair(val, Math.max(val, st.peek().second)));
        }
    }

    int getMax() {
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


class MaxStackClient {

    static class OptimizeMaxStack {

        Stack<Integer> stack;
        int max;

        OptimizeMaxStack() {
            stack = new Stack<>();
        }

        void push(int x) {

            if(stack.isEmpty()){
                stack.push(0); // store 0 initially
                max = x;
            } else {
                stack.push(x-max);

                if(x > max) {
                    max = x; // this is new minimum
                }
            }
        }

        int pop() {

            int top = stack.pop();
            int val;

            if( top > 0) {
                val = max;
                max = max - top; // pop value itself max

            } else {
                val = max + top;
            }

            return val;
        }

        int top() {

            int top = stack.peek();

            if( top > 0) {
                return max;
            } else  {
                return top + max;
            }
        }

        int getMax() {
            return max;
        }

        void printStack() {
            System.out.println(stack);
        }
    }

    public static void main(String[] args) {

        System.out.println("***********************************************************************");
        System.out.println("                               Bruteforce                              ");
        System.out.println("***********************************************************************");

        SQ07MaxStack maxStack = new SQ07MaxStack();

        maxStack.push(12);
        maxStack.push(15);
        maxStack.push(10);

        maxStack.printStack();

        System.out.println(maxStack.getMax());

        maxStack.pop();

        maxStack.printStack();

        System.out.println(maxStack.top());

        System.out.println(maxStack.getMax());

        maxStack.pop();

        maxStack.printStack();

        System.out.println(maxStack.getMax());

        System.out.println("***********************************************************************");
        System.out.println("                               Optimal                                 ");
        System.out.println("***********************************************************************");

        OptimizeMaxStack maxStackOP = new OptimizeMaxStack();

        maxStackOP.push(12);
        maxStackOP.push(15);
        maxStackOP.push(10);

        maxStackOP.printStack();

        System.out.println(maxStackOP.getMax());

        maxStackOP.pop();

        maxStackOP.printStack();

        System.out.println(maxStackOP.top());

        maxStackOP.pop();

        maxStackOP.printStack();

        System.out.println(maxStackOP.getMax());

    }
}
