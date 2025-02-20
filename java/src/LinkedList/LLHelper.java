package LinkedList;

public class LLHelper {

    protected static void printSLL(SingleLLNode head){

        if(head == null){
            System.out.println("List is empty");
        }

        SingleLLNode temp = head;

        while(temp != null){
            System.out.printf(temp.data + "--->");
            temp = temp.next;
        }
        System.out.printf("x\n");
    }

    protected static void printDLL(DoubleLLNode head){

        if(head == null){
            System.out.println("List is empty");
        }

        DoubleLLNode temp = head;
        System.out.printf( "Head--->");
        while(temp != null){
            System.out.printf(temp.data + "--->");
            temp = temp.next;

        }
        System.out.printf("x\n");
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("   x");
        while (temp != null) {
            System.out.print("<---"+temp.data );
            temp = temp.prev;
        }
        System.out.printf("<---Head\n");
    }
}
