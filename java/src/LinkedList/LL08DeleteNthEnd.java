package LinkedList;

public class LL08DeleteNthEnd {

    public static void main(String[] args) {
        Integer[] arr1 = {1, 3, 4, 2, 5, 6,};
        SingleLLNode input1 = LLHelper.convertToLL(arr1);
        LLHelper.printSLL(input1);

        System.out.println("Bruteforce Approach: ");
        bruteforce(input1,3);
        LLHelper.printSLL(input1);


        Integer[] arr2 = {1, 3, 4, 2, 5, 6,};
        SingleLLNode input2 = LLHelper.convertToLL(arr1);
        LLHelper.printSLL(input2);

        System.out.println("Optimal Approach: ");
        optimal(input2,3);
        LLHelper.printSLL(input2);
    }

    private static SingleLLNode bruteforce(SingleLLNode head, int n) {

        // count total node as t, then delete node x-n

        int counter = 0;

        SingleLLNode curr = head;

        while (curr != null) {
            counter++;
            curr = curr.next;
        }

        int nodeN = counter - n;

        if (nodeN < 0) {
            return head;
        }

        if(nodeN == 0){
            return head.next;
        }

        curr = head;
        counter = 0;

        while (curr != null) {
            counter ++;
            if(counter == nodeN){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;

    }

    private static SingleLLNode optimal(SingleLLNode head, int n) {

        SingleLLNode fast = head;
        SingleLLNode slow = head;

        for(int i = 1; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null ) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }


        return head;
    }
}
