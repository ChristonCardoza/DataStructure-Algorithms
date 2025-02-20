package LinkedList;

public class LL01ArrayToLL {

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SingleLLNode head = convertToLL(arr);

        LLHelper.printSLL(head);
    }

    private static SingleLLNode convertToLL(Integer[] arr) {

        SingleLLNode head = new SingleLLNode(arr[0]);
        SingleLLNode current = head;

         for (int i = 1; i < arr.length; i++) {
             current.next = new SingleLLNode(arr[i]);
             current = current.next;
         }

         return head;
    }
}
