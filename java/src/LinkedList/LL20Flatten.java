package LinkedList;

public class LL20Flatten {

    /*
    *
    *               3 ---> 2 ---> 1 ---> 4 ---> 5 ---> x
    *               |      |      |      |      |
    *               X      10     7      9      6
    *                      |      |      |      |
    *                      X      11     X      8
    *                             |             |
    *                             12            X
    *                             |
    *                             X
    *
    * */

    public static void main(String[] args) {

    }

    private static SingleLLNode flatten(SingleLLNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        SingleLLNode mergedHead = flatten(head.next);
//        head = merge(head,mergedHead);
        return head;
    }

//    private static SingleLLNode merge(SingleLLNode l1, SingleLLNode l2) {
//
//        SingleLLNode dummy = new SingleLLNode(-1);
//        SingleLLNode res = dummy;
//
//        while (l1 != null && l2 != null) {
//
//            if (l1.data < l2.data) {
//                res.child = l1;
//                l1 = l1.child;
//            } else {
//                res.child = l2;
//                l2 = l2.child;
//            }
//            res = res.child;
//            res.next = null;
//        }
//
//        if(l1.child != null) {
//            res.child = l1.child;
//        } else {
//            res.child = l2.child;
//        }
//
//        if(dummy.child) {
//            dummy.child.next = null;
//        }
//
//        return dummy.child;
//    }
}
