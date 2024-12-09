package StackQueue;

public class SQ01StackImpl {

    private int top;
    private final int capacity;
    private final int[] stack;

    SQ01StackImpl(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    boolean isFull(){
        return capacity -1 == top;
    }

    boolean isEmpty(){
        return top == -1;
    }

    void push(int ele) {
        if(!isFull()){
            top ++;
            stack[top] = ele;
        } else {
            System.out.println("Stack is Full...");
        }
    }

    Integer pop() {

        Integer ele = null;

        if(isEmpty()){
            System.out.println("Stack is Empty");
        } else {
            ele = stack[top];
            top = top-1;
            System.out.println(ele+" added to the stack");
        }

        return ele;
    }

    Integer peek(){
        Integer ele = null;

        if(isEmpty()){
            System.out.println("Stack is Empty");
        } else {
            ele = stack[top];
        }

        return ele;
    }


}

class StackClient {

    public static void main(String[] args) {

        SQ01StackImpl st = new SQ01StackImpl(5);

        System.out.println("Is stack full " + st.isFull());
        System.out.println("Is stack empty " + st.isEmpty());
        st.push(5);
        System.out.println("Is stack empty " + st.isEmpty());
        System.out.println("Popping " + st.pop());
        System.out.println("Popping " + st.pop());
        st.push(2);
        st.push(8);
        st.push(54);
        st.push(15);
        st.push(35);
        System.out.println("Is stack full " + st.isFull());
        st.push(35);
        System.out.println("Top of the stack " + st.peek());
    }
}
