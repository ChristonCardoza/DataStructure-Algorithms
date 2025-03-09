package LinkedList;

public class LL07Sorting {

    public static void main(String[] args) {

        Integer[] arr1 = {0, 0, 1, 1,2, 0, 1, 2, 2, 0, 1, 0};
        SingleLLNode input1 = LLHelper.convertToLL(arr1);
        LLHelper.printSLL(input1);

        System.out.println("Bruteforce Approach: ");
        bruteforce(input1);
        LLHelper.printSLL(input1);

        Integer[] arr2 = {0, 0, 1, 1,2, 0, 1, 2, 2, 0, 1, 0};
        SingleLLNode input2 = LLHelper.convertToLL(arr1);
        LLHelper.printSLL(input1);

        System.out.println("Optimal Approach: ");
        optimal(input2);
        LLHelper.printSLL(input2);
    }

    private static SingleLLNode bruteforce(SingleLLNode head) {

        if (head == null) { return head; }

        int[] counter = new int[3];

        SingleLLNode current = head;

        while (current != null) {

            if(current.data == 0) {
                counter[0]++;
            } else if(current.data == 1) {
                counter[1]++;
            } else {
                counter[2]++;
            }
            current = current.next;
        }

        SingleLLNode temp = head;

        while(counter[0] != 0) {
            temp.data = 0;
            temp = temp.next;
            counter[0]--;
        }

        while(counter[1] != 0) {
            temp.data = 1;
            temp = temp.next;
            counter[1]--;
        }

        while(counter[2] != 0) {
            temp.data = 2;
            temp = temp.next;
            counter[2]--;
        }

        return head;
    }

    private static SingleLLNode optimal(SingleLLNode head) {
        if (head == null) { return head; }

        SingleLLNode zeroHead = new SingleLLNode(-1);
        SingleLLNode zero = zeroHead;
        SingleLLNode oneHead = new SingleLLNode(-1);
        SingleLLNode one = oneHead;
        SingleLLNode twoHead = new SingleLLNode(-1);
        SingleLLNode two = twoHead;

        SingleLLNode temp = head;

        while(temp != null) {

            if(temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if(temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else if(temp.data == 2) {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }

        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return head;
    }
}
