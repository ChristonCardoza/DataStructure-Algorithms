package LinkedList;

public class LL17ReverseKGroup {

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SingleLLNode root = LLHelper.convertToLL(arr);
        LLHelper.printSLL(root);
        System.out.println("After reverse K Group: ");
        SingleLLNode kReverse = reverseKGroup(root, 3);
        LLHelper.printSLL(kReverse);
    }

    private static SingleLLNode reverseKGroup(SingleLLNode head, int k) {

        SingleLLNode current = head;
        SingleLLNode prevLast = null;

        while (current != null) {

            SingleLLNode kNode = getKthNode(current, k);

            if (kNode == null) {

                if (prevLast != null) {
                    prevLast.next = current;
                }

                break;
            }

            SingleLLNode kthNext = kNode.next;
            kNode.next = null;
            reverse(current);

            // after fist reversal set head
            if(current == head) {
                head = kNode;
            } else {
                prevLast.next = kNode;
            }

            prevLast = current;
            current = kthNext;
        }

        return head;
    }

    private static SingleLLNode getKthNode(SingleLLNode head, int k) {
        SingleLLNode current = head;

        while(k > 1 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    private static SingleLLNode reverse(SingleLLNode head) {

        SingleLLNode current = head;
        SingleLLNode prev = null;

        while (current != null) {
            SingleLLNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        return prev;
    }


}
