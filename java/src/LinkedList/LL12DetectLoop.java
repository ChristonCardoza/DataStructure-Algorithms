package LinkedList;

public class LL12DetectLoop {

    public static void main(String[] args) {

        SingleLLNode head1 = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3)));
        SingleLLNode loopStart = head1.next.next;
        SingleLLNode loop = new SingleLLNode(4, new SingleLLNode(5, new SingleLLNode(6, new SingleLLNode(7, new SingleLLNode(8, new SingleLLNode(9, new SingleLLNode(10, loopStart)))))));
        loopStart.next = loop;

        isLoop(head1);

        SingleLLNode head2 = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3)));

       isLoop(head2);

    }

    private static void isLoop(SingleLLNode head) {

        SingleLLNode fast = head;
        SingleLLNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                System.out.println("Loop Found !");

                // Find the loop length
                int count = 1;
                fast = fast.next;

                while( fast != slow) {
                    fast = fast.next;
                    count++;
                }
                System.out.println("The length of the loop is: " + count);

                // find starting point of loop
                slow = head;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                System.out.println("The start of the loop is: " + fast.data);

                return;
            }
        }

        System.out.println("No loop found!" );
        return;
    }


}
