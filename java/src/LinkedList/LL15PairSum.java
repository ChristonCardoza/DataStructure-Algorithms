package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class LL15PairSum {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 9};
        int sum = 5;
        DoubleLLNode root = LLHelper.convertToDLL(arr);
        LLHelper.printDLL(root);

        System.out.println("The Pair having sum " + 5 +  "is : ");
        List<List<DoubleLLNode>> pairList = getPair(root, 5);
        for(List<DoubleLLNode> pair : pairList){
            System.out.println("(" + pair.get(0).data + "," + pair.get(1).data + ")");
        }

    }

    private static List<List<DoubleLLNode>> getPair(DoubleLLNode head, int sum) {

        if (head == null) {
            return null;
        }

        DoubleLLNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        DoubleLLNode left = head;
        DoubleLLNode right = tail;

        List<List<DoubleLLNode>> pairList = new ArrayList<>();

        while( left.data < right.data ) {

            List<DoubleLLNode> pair = new ArrayList<>();

            if(left.data + right.data == sum) {
                pair.add(left);
                pair.add(right);

                pairList.add(pair);

                left = left.next;
                right = right.prev;
            } else if( left.data + right.data < sum ) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return pairList;
    }
}
