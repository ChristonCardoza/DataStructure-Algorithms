package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class LL15PairSum {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 9};
        int sum = 5;
        DoubleLLNode<Integer> root = LLHelper.convertToDLL(arr);
        LLHelper.printDLL(root);

        System.out.println("The Pair having sum " + 5 +  "is : ");
        List<List<DoubleLLNode<Integer>>> pairList = getPair(root, 5);
        for(List<DoubleLLNode<Integer>> pair : pairList){
            System.out.println("(" + pair.get(0).data + "," + pair.get(1).data + ")");
        }

    }

    private static List<List<DoubleLLNode<Integer>>> getPair(DoubleLLNode<Integer> head, int sum) {

        if (head == null) {
            return null;
        }

        DoubleLLNode<Integer> tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        DoubleLLNode<Integer> left = head;
        DoubleLLNode<Integer> right = tail;

        List<List<DoubleLLNode<Integer>>> pairList = new ArrayList<>();

        while( left.data < right.data ) {

            List<DoubleLLNode<Integer>> pair = new ArrayList<>();

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
