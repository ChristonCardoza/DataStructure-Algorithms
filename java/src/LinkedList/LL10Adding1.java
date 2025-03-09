package LinkedList;

public class LL10Adding1 {

    /*
     *  1 --> 5 --> 9
     *              1
     * -------------------
     *  1 --> 6 -->0
     * */

    public static void main(String[] args) {

        System.out.println("Bruteforce Approach: ");

        Integer[] arr1 = {2, 9, 9};
        SingleLLNode input1 = LLHelper.convertToLL(arr1);
        LLHelper.printSLL(input1);

        SingleLLNode brueforce = bruteforce(input1);
        LLHelper.printSLL(brueforce);

        Integer[] arr2 = {9, 9, 9};
        SingleLLNode input2 = LLHelper.convertToLL(arr2);
        LLHelper.printSLL(input2);

        SingleLLNode brueforce2 = bruteforce(input2);
        LLHelper.printSLL(brueforce2);

        System.out.println("Optimal Approach: ");

        Integer[] arr3 = {2, 9, 8};
        SingleLLNode input3 = LLHelper.convertToLL(arr3);
        LLHelper.printSLL(input3);

        SingleLLNode optimal1 = optimal(input3);
        LLHelper.printSLL(optimal1);

        Integer[] arr4 = {9, 9, 9};
        SingleLLNode input4 = LLHelper.convertToLL(arr4);
        LLHelper.printSLL(input4);

        SingleLLNode optimal2 = optimal(input4);
        LLHelper.printSLL(optimal2);
    }

    private static SingleLLNode bruteforce(SingleLLNode head) {

        // Revere a list and add carry

        SingleLLNode reversedHead = reverse(head);
        SingleLLNode curr = reversedHead;

        int carry = 1;


        while(curr != null) {
            int sum = 0;
            sum += carry;
            sum += curr.data;

            curr.data = sum % 10;
            carry = sum / 10;

            curr = curr.next;
        }

        if(carry > 0) {

            SingleLLNode node = new SingleLLNode(carry);
            node.next = reversedHead;

            return node;
        }
        return reverse(reversedHead);
    }

    private static SingleLLNode reverse(SingleLLNode head) {

        SingleLLNode curr = head;
        SingleLLNode prev = null;

        while(curr != null) {

            SingleLLNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static SingleLLNode optimal(SingleLLNode head) {

        int carry = helper(head);

        if(carry == 1){
            SingleLLNode node = new SingleLLNode(1);
            node.next = head;
            return node;
        }
        return head;
    }

    private static int helper(SingleLLNode node) {

        if(node == null) {
            return 1;
        }

        int carry = helper(node.next);

        node.data = node.data + carry;

        if(node.data < 10) {
            return 0;
        }

        node.data = 0;

        return 1;
    }
}
