package LinkedList;

import java.util.Stack;

public class LL09Palindrome {

    public static void main(String[] args) {

        Integer[] arr1 = {1, 3, 4, 2, 5, 6,};
        SingleLLNode input1 = LLHelper.convertToLL(arr1);
        LLHelper.printSLL(input1);

        System.out.println("Bruteforce Approach: "+ bruteforce(input1));
        System.out.println("Optimal Approach: "+ optimal(input1));

        Integer[] arr2 = {1, 3, 4, 3, 1};
        SingleLLNode input2 = LLHelper.convertToLL(arr2);
        LLHelper.printSLL(input2);

        System.out.println("Bruteforce Approach: "+ bruteforce(input2));
        System.out.println("Optimal Approach: "+ optimal(input2));


    }

    private static boolean bruteforce(SingleLLNode head) {
        SingleLLNode curr = head;

        Stack<Integer> stack = new Stack<>();

        while(curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }

        curr = head;

        while(!stack.isEmpty()) {

            if(!stack.peek().equals(curr.data)) {
                return false;
            }
            stack.pop();
            curr = curr.next;
        }
        return true;

    }

    private static boolean optimal(SingleLLNode head) {

        if(head == null && head.next == null) { return true; }

        SingleLLNode slow = head;
        SingleLLNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        SingleLLNode newHead = reverse(slow.next);

        SingleLLNode first = head;
        SingleLLNode second = newHead;

        while(second != null) {

            if(first.data != second.data) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
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
}
