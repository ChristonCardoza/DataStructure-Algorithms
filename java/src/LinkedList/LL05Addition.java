package LinkedList;


public class LL05Addition {


    public static void main(String[] args) {

        Integer[] arr1 = {2, 4, 6};
        Integer[] arr2 = {3, 8, 7};

        SingleLLNode head1 = LLHelper.convertToLL(arr1);
        SingleLLNode head2 = LLHelper.convertToLL(arr2);

        SingleLLNode addedLL =addition(head1, head2);
        LLHelper.printSLL(addedLL);
    }

    private static SingleLLNode addition(SingleLLNode node1, SingleLLNode node2) {

        SingleLLNode dummy = new SingleLLNode(-1);

        SingleLLNode curr = dummy;
        SingleLLNode temp1 = node1;
        SingleLLNode temp2 = node2;
        int carry = 0;

        while(temp1 != null || temp2 != null ) {

            int sum = carry;

            if(temp1 != null) {
                sum += temp1.data;
            }
            if(temp2 != null) {
                sum += temp2.data;
            }

            SingleLLNode newNode = new SingleLLNode(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;

            if(temp1 != null) {
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                temp2 = temp2.next;
            }
        }

        if(carry > 0) {
            SingleLLNode carryNode = new SingleLLNode(carry);
            curr.next = carryNode;
        }

        return dummy.next;
    }
}
