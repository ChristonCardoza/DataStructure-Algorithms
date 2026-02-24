package LinkedList;

public class SingleLLNode {
    Integer data;
    SingleLLNode next;
    SingleLLNode random;

    SingleLLNode(){
        data = null;
        next = null;
    }

    SingleLLNode(Integer data){
        this.data = data;
    }

    SingleLLNode(Integer data, SingleLLNode next){
        this.data = data;
        this.next = next;
    }

}
