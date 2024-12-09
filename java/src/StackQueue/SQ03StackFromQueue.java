package StackQueue;

import java.util.Queue;

public class SQ03StackFromQueue {

    Queue<Integer> q;

    void push(int x) {
        int s = q.size();
        q.add(x);

        for(int i=1; i<s; i++){
            q.add(q.poll());
        }
    }

    Integer pop() {
        return q.poll();
    }

    Integer top() {
        return q.peek();
    }
}
