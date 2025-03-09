package LinkedList;

public class LL11Collision {

    /*
    *                  3 --> 1
    *                          \
    *                            --> 4 --> 6 --> 2
    *      1 --> 2 --> 4 -->   /
    *
    * */

    public static void main(String[] args) {

        SingleLLNode commonNode = new SingleLLNode(4, new SingleLLNode(6, new SingleLLNode(2)));

        SingleLLNode firstNode = new SingleLLNode(3, new SingleLLNode(1, commonNode));
        LLHelper.printSLL(firstNode);
        SingleLLNode secondNode = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(4, new SingleLLNode(5, commonNode))));
        LLHelper.printSLL(secondNode);

        System.out.println("Bruteforce Approach: "+ bruteforce(firstNode, secondNode));
        System.out.println("Optimal Approach: "+ bruteforce(firstNode, secondNode));
    }

    private static int bruteforce(SingleLLNode head1, SingleLLNode head2) {

        /*
        *   check the length of both list, find out there difference, based on difference position longer pointer
        *
        * */

        SingleLLNode t1 = head1;
        int n1 = 0;
        SingleLLNode t2 = head2;
        int n2 = 0;

        while (t1 != null) {
            n1 ++;
            t1 = t1.next;
        }

        while (t2 != null) {
            n2 ++;
            t2 = t2.next;
        }

        if (n1 > n2) {
            return collisionPoint(head1, head2, n1-n2);
        }else {
            return collisionPoint(head2, head1, n2-n1);
        }

    }

    private static int collisionPoint(SingleLLNode head1, SingleLLNode head2, int d) {

        while(d>0){
            d--;
            head1 = head1.next;
        }

        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1.data;
    }

    private static int optimal(SingleLLNode head1, SingleLLNode head2){

        /*
        *  traverse both the list together, shorter one ends first, move shorter one pointing to longer one,
        *  again traverse, whichever end goes to opposite head
        * */

        SingleLLNode t1 = head1;
        SingleLLNode t2 = head2;

        while(t1 != t2){
            t1 = (t1 == null) ? head2 : t1.next;
            t2 = (t2 == null) ? head1 : t2.next;
        }

        return (t1 != null) ? t1.data : -1;
    }
}
