package StackQueue;

import java.util.Stack;

public class SQ04QueueFromStack {

    Stack<Integer> s1, s2;

//    void push(int x) {
//
//        while(!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//
//        s1.push(x);
//
//        while (!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
//    }
//
//    int top() {
//        return s1.peek();
//    }
//
//    int pop() {
//        return s1.pop();
//    }

    void push(int x) {
        s1.push(x);
    }

    int pop() {

        if(!s2.isEmpty()) {
            return s2.pop();
        } else {

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            return s2.pop();
        }
    }

    int top() {
        if(!s2.isEmpty()) {
            return s2.peek();
        } else {

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            return s2.peek();
        }
    }
}
