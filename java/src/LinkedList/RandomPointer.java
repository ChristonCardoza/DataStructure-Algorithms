package LinkedList;

public class RandomPointer extends SingleLLNode{

    RandomPointer random;

    RandomPointer(Integer data, RandomPointer next, RandomPointer random){

        super(data, next);
        this.random = random;
    }
}
