package LinkedList;

public class DoubleLLNode<T> {

    T data;
    DoubleLLNode<T> next;
    DoubleLLNode<T> prev;

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

    DoubleLLNode(T data, DoubleLLNode<T> next, DoubleLLNode<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
