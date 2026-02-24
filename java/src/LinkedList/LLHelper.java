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

    protected static void printDLL(DoubleLLNode<Integer> head){

        if(head == null){
            System.out.println("List is empty");
        }

        DoubleLLNode<Integer> temp = head;
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

    protected static SingleLLNode convertToLL(Integer[] arr) {

        if(arr == null || arr.length == 0){ return  null;}

        SingleLLNode head = new SingleLLNode(arr[0]);
        SingleLLNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new SingleLLNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    protected static DoubleLLNode<Integer> convertToDLL(Integer[] arr) {

        if(arr == null || arr.length == 0){ return  null;}

        DoubleLLNode<Integer> head = new DoubleLLNode<>(arr[0]);
        DoubleLLNode<Integer> current = head;
        DoubleLLNode<Integer> prev = null;

        for (int i = 1; i < arr.length; i++) {
            current.next = new DoubleLLNode<>(arr[i]);
            current.prev = prev;
            prev = current;
            current = current.next;
        }
        current.prev = prev;

        return head;
    }
}
