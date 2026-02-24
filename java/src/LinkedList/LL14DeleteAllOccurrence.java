package LinkedList;

public class LL14DeleteAllOccurrence {
    public static void main(String[] args) {

        DoubleLLNode<Integer> Dhead = new DoubleLLNode<>(10);
        Dhead.next = new DoubleLLNode<>(4);
        Dhead.next.prev = Dhead;

        Dhead.next.next = new DoubleLLNode<>(10);
        Dhead.next.next.prev = Dhead.next;

        Dhead.next.next.next = new DoubleLLNode<>(10);
        Dhead.next.next.next.prev = Dhead.next.next;

        Dhead.next.next.next.next = new DoubleLLNode<>(6);
        Dhead.next.next.next.next.prev = Dhead.next.next.next;

        Dhead.next.next.next.next.next = new DoubleLLNode<>(10);
        Dhead.next.next.next.next.next.prev = Dhead.next.next.next.next;

        LLHelper.printDLL(Dhead);

        int key = 10;

        System.out.println("Delete all occurrences of " + key);
        LLHelper.printDLL(removeOccurrence(Dhead, key));

    }

    private static DoubleLLNode<Integer> removeOccurrence(DoubleLLNode<Integer> head, int key) {

        if(head == null){
            return null;
        }

        DoubleLLNode<Integer> current = head;

        while(current != null){

            if(current.data == key){

                if(current == head) {
                    head = head.next;
                }

                DoubleLLNode next = current.next;
                DoubleLLNode prev = current.prev;

                if(next != null){
                    next.prev = prev;
                }

                if(prev != null){
                    prev.next = next;
                }

                current = next;

            } else {
                current = current.next;
            }
        }

        return head;
    }
}
