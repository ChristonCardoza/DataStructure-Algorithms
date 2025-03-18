package LinkedList;

public class LL18RotateK {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SingleLLNode root = LLHelper.convertToLL(arr);
        LLHelper.printSLL(root);
        System.out.println("After K rotation: ");
        SingleLLNode rotated = rotate(root, 2);
        LLHelper.printSLL(rotated);
    }

    private static SingleLLNode rotate(SingleLLNode head, int k) {

        SingleLLNode tail = head;
        int len = 1;

        while(tail.next != null) {
            tail = tail.next;
            len++;
        }

        if(k % len == 0) {
            return head;
        }

        k  = k % len;

        // connect to head so it will circular
        tail.next = head;

        // find new tail after rotation ie len-k

        SingleLLNode newTail = head;
        int end = len - k;
        while(end > 1) {
            newTail = newTail.next;
            end--;
        }

        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
