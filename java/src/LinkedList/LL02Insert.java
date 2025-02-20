package LinkedList;

public class LL02Insert {

    public static void main(String[] args) {

        System.out.println("--------------------insertHead------------------------------");
        SingleLLNode head = insertHead(null, 5);
        LLHelper.printSLL(head);
        System.out.println("--------------------insertHead------------------------------");
        head = insertHead(head, 4);
        LLHelper.printSLL(head);


        System.out.println("---------------------insertTail-----------------------------");
        head = insertTail(head, 11);
        LLHelper.printSLL(head);
        System.out.println("---------------------insertTail-----------------------------");
        head = insertTail(head, 12);
        LLHelper.printSLL(head);

        System.out.println("----------------------insertKthLoc---------------------------");
        head = insertKthLoc(head, 8, 1);
        LLHelper.printSLL(head);
        System.out.println("-----------------------insertKthLoc--------------------------");
        head = insertKthLoc(head, 13, 2);
        LLHelper.printSLL(head);
        System.out.println("-----------------------insertKthLoc--------------------------");
        head = insertKthLoc(head, 20, 7);
        LLHelper.printSLL(head);


    }

    private static SingleLLNode insertHead(SingleLLNode head, int data) {
        SingleLLNode temp = new SingleLLNode(data);
        temp.next = head;
        return temp;
    }

    private static SingleLLNode insertTail(SingleLLNode head, Integer data) {

        SingleLLNode temp = head;

        if(temp == null){
            return insertHead(head, data);
        }

        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new SingleLLNode(data);

        return head;
    }

    private static SingleLLNode insertKthLoc(SingleLLNode head, Integer data, int k) {

        if(k == 1){
            return insertHead(head, data);
        }

        int count = 0;

        SingleLLNode temp = head;

        while(temp != null){

            count++;

            if(count == k-1){

                SingleLLNode next = temp.next;
                SingleLLNode newNode = new SingleLLNode(data, next);
                temp.next = newNode;
                break;

            }

            temp = temp.next;

        }

        return head;
    }
}
