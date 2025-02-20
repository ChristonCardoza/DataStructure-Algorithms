package LinkedList;

public class LL03Delete {

    public static void main(String[] args) {

        System.out.println("--------------------deleteHead------------------------------");
        SingleLLNode head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4))));
        LLHelper.printSLL(head);
        head = deleteHead(head);
        LLHelper.printSLL(head);
        System.out.println("--------------------deleteTail------------------------------");
        head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4))));
        LLHelper.printSLL(head);
        head = deleteTail(head);
        LLHelper.printSLL(head);
        System.out.println("--------------------deleteKthLoc------------------------------");
        head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(5)))));
        LLHelper.printSLL(head);
        head = deleteKthLoc(head, 1);
        LLHelper.printSLL(head);
        head = deleteKthLoc(head, 4);
        LLHelper.printSLL(head);
        head = deleteKthLoc(head, 2);
        LLHelper.printSLL(head);


    }

    private static SingleLLNode deleteHead(SingleLLNode head) {

        if(head == null){
            return null;
        }

        return head.next;
    }

    private static SingleLLNode deleteTail(SingleLLNode head) {
        if(head == null){
            return null;
        }

        SingleLLNode prev = head;
        while(prev.next!=null && prev.next.next != null){
            prev = prev.next;
        }

        prev.next = null;

        return head;
    }

    private static SingleLLNode deleteKthLoc(SingleLLNode head, int k) {

        if(k == 1){
            return deleteHead(head);
        }

        int count = 0;
        SingleLLNode temp = head;
        SingleLLNode prev = null;

        while(temp!=null){
            count++;

            if(count == k){
                prev.next = temp.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}
