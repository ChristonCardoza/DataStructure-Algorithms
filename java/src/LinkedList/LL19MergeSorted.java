package LinkedList;

public class LL19MergeSorted {
    public static void main(String[] args) {

        Integer[] arr1 = {2, 4, 8, 10};
        SingleLLNode l1 = LLHelper.convertToLL(arr1);
        Integer[] arr2 = {1, 3, 3, 6, 11, 14};
        SingleLLNode l2 = LLHelper.convertToLL(arr2);

        LLHelper.printSLL(l1);
        LLHelper.printSLL(l2);

        System.out.println("After Merging:  ");
        SingleLLNode mergeSorted = mergeSorted(l1, l2);
        LLHelper.printSLL(mergeSorted);
    }

    private static SingleLLNode mergeSorted(SingleLLNode l1, SingleLLNode l2) {

        SingleLLNode t1 = l1;
        SingleLLNode t2 = l2;

        SingleLLNode dummy = new SingleLLNode(-1);
        SingleLLNode temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        if (t1 != null) {
            temp.next = t1;
        }else {
            temp.next = t2;
        }

        return dummy.next;
    }
}
