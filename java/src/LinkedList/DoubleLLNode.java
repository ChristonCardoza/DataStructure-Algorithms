package LinkedList;

public class DoubleLLNode<T> {

    T data;
    DoubleLLNode next;
    DoubleLLNode prev;

    DoubleLLNode(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    DoubleLLNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    DoubleLLNode(T data, DoubleLLNode next, DoubleLLNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
