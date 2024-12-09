package StackQueue;

public class SQ02QueueImpl {

    private int front;
    private int rear;
    private int size;
    private final int capacity;
    private final int[] queue;

    SQ02QueueImpl(int capacity){
        this.front = 0;
        this.rear = -1;
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return  size == 0;
    }

    Integer peek() {
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return null;
        }
        return queue[front];
    }

    void enqueue(int val) {
        if(isFull()) {
            System.out.println("The queue is full!");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = val;
        size ++;
    }

    Integer dequeue() {
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return null;
        }

        int val = queue[front];
        front = (front + 1) % capacity;
        size --;
        return val;
    }

}

class QueueClient {

    public static void main(String[] args) {

        SQ02QueueImpl queue = new SQ02QueueImpl(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Front element: " + queue.peek()); // Output: 10
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 10
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 20
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("Front element: " + queue.peek()); // Output: 30


    }

}
