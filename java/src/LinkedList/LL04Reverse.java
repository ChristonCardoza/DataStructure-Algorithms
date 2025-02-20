package LinkedList;

public class LL04Reverse {

    public static void main(String[] args) {
        System.out.println("--------------------reverseItr------------------------------");
        SingleLLNode head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(5)))));
        LLHelper.printSLL(head);
        SingleLLNode revItr = reverseItr(head);
        LLHelper.printSLL(revItr);
        System.out.println("--------------------reverseRec------------------------------");
        head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(5)))));
        LLHelper.printSLL(head);
        SingleLLNode revRec = reverseRec(head);
        LLHelper.printSLL(revRec);
        System.out.println("--------------------reverseDLL------------------------------");
        DoubleLLNode Dhead = new DoubleLLNode(1);
        Dhead.next = new DoubleLLNode(2);
        Dhead.next.prev = Dhead;

        Dhead.next.next = new DoubleLLNode(3);
        Dhead.next.next.prev = Dhead.next;

        Dhead.next.next.next = new DoubleLLNode(4);
        Dhead.next.next.next.prev = Dhead.next.next;

        Dhead.next.next.next.next = new DoubleLLNode(5);
        Dhead.next.next.next.next.prev = Dhead.next.next.next;
        LLHelper.printDLL(Dhead);
        DoubleLLNode reverseLL = reverseDll(Dhead);
        LLHelper.printDLL(reverseLL);
    }

    public static SingleLLNode reverseItr(SingleLLNode head) {

        SingleLLNode prev = null;
        SingleLLNode curr = head;

        while (curr != null) {
            SingleLLNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    public static SingleLLNode reverseRec(SingleLLNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        SingleLLNode newHead = reverseRec(head.next);
        SingleLLNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;

    }

    public static DoubleLLNode reverseDll(DoubleLLNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoubleLLNode temp = null;
        DoubleLLNode curr = head;

        while (curr!= null) {

            temp = curr.prev;

            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        return temp.prev;
    }
}
