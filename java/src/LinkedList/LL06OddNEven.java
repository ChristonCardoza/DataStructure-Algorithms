package LinkedList;

public class LL06OddNEven {

    /*
    *      1 ---> 3 ---> 4 ---> 2 ---> ---> 5 ---> 6
    *
    *      1 ---> 4 ---> 5 ---> 3 ---> 2 ---> 6
    *      |_____________|      |_____________|
    *            odd                even
    * */

    public static void main(String[] args) {

        Integer[] arr = {1, 3, 4,  2, 5, 6,};
        SingleLLNode input = LLHelper.convertToLL(arr);
        LLHelper.printSLL(input);

        System.out.println("Bruteforce Approach: ");
        SingleLLNode bruteForce = bruteforce(input);
        LLHelper.printSLL(bruteForce);

        System.out.println("Optimal Approach: ");
        SingleLLNode optimal = optimal(input);
        LLHelper.printSLL(optimal);

    }

    private static SingleLLNode bruteforce(SingleLLNode head) {

        if (head == null) return null;

        SingleLLNode oddPointer = head;
        SingleLLNode evenPointer = head.next;

        SingleLLNode slowDummy = new SingleLLNode(-1);
        SingleLLNode fastDummy = new SingleLLNode(-1);

        SingleLLNode odd = slowDummy;
        SingleLLNode even = fastDummy;

        while(oddPointer != null && oddPointer.next != null) {
            odd.next = new SingleLLNode(oddPointer.data);
            oddPointer = oddPointer.next.next;
            odd = odd.next;
        }
//        if(oddPointer != null) {
//            odd.next = new SingleLLNode(oddPointer.data);;
//        }

        while(evenPointer != null && evenPointer.next != null) {
            even.next = new SingleLLNode(evenPointer.data);
            evenPointer = evenPointer.next.next;
            even = even.next;
        }

        if(evenPointer != null) {
            even.next = new SingleLLNode(evenPointer.data);;
        }

        odd.next = fastDummy.next;
        return slowDummy.next;
    }

    private static SingleLLNode optimal(SingleLLNode head){

        if(head == null || head.next == null) return head;

        SingleLLNode odd = head;
        SingleLLNode even = head.next;
        SingleLLNode evenHead = even;

        while(even != null && even.next != null) {

            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead.next;
        return head;

    }
}
