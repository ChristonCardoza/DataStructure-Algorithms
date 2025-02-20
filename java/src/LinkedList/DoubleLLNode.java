package LinkedList;

public class DoubleLLNode {

    Integer data;
    DoubleLLNode next;
    DoubleLLNode prev;

    DoubleLLNode(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    DoubleLLNode(Integer data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    DoubleLLNode(Integer data, DoubleLLNode next, DoubleLLNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
