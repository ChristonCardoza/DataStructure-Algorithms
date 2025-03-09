package LinkedList;

public class LL13Middle {

    public static void main(String[] args) {

        SingleLLNode head1 = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(5)))));
        LLHelper.printSLL(head1);
        System.out.println("Middle: " + getMiddle(head1));
        System.out.println("Deleting Middle: ");
        LLHelper.printSLL(deleteMiddle(head1));

        SingleLLNode head2 = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(5, new SingleLLNode(6, new SingleLLNode(7)))))));
        LLHelper.printSLL(head2);
        System.out.println("Middle: " + getMiddle(head2));
        System.out.println("Deleting Middle: ");
        LLHelper.printSLL(deleteMiddle(head2));
    }

    private static int getMiddle(SingleLLNode head) {

        SingleLLNode slow = head;
        SingleLLNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    private static  SingleLLNode deleteMiddle(SingleLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // skip one step
        SingleLLNode slow = head;
        SingleLLNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}
