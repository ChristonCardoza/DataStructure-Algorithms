package LinkedList;

public class LL22Sort {

    public static void main(String[] args) {

        Integer[] arr = {23, 87, 56, 14, 72, 39, 91, 8, 65, 47, 33, 99, 5, 76, 28, 42, 11, 94, 60, 19};
        SingleLLNode head = LLHelper.convertToLL(arr);
        LLHelper.printSLL(head);

        System.out.println("After Sorting the LinkedList: ");
        SingleLLNode sorted = sortLL(head);
        LLHelper.printSLL(sorted);

    }

    private static  SingleLLNode sortLL(SingleLLNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        SingleLLNode middle = findMiddle(head);
        SingleLLNode left = head;
        SingleLLNode right = middle.next;
        middle.next = null;

        left = sortLL(left);
        right = sortLL(right);

        return merge(left, right);

    }

    private static SingleLLNode findMiddle(SingleLLNode head) {

        SingleLLNode slow = head;
        SingleLLNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static SingleLLNode merge(SingleLLNode l1, SingleLLNode l2) {

        SingleLLNode dummy = new SingleLLNode(-1);
        SingleLLNode curr = dummy;

        while(l1 != null && l2 != null) {

            if(l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) {
            curr.next = l1;
        }else  {
            curr.next = l2;
        }

        return dummy.next;
    }
}
