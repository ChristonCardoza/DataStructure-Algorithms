package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LL21MergeKSorted {

    public static void main(String[] args) {

        Integer[] arr1 = {2, 4, 6};
        SingleLLNode l1 = LLHelper.convertToLL(arr1);
        Integer[] arr2 = {1, 5};
        SingleLLNode l2 = LLHelper.convertToLL(arr2);
        Integer[] arr3 = {1, 1, 3, 7};
        SingleLLNode l3 = LLHelper.convertToLL(arr3);
        Integer[] arr4 = {8};
        SingleLLNode l4 = LLHelper.convertToLL(arr4);

        LLHelper.printSLL(l1);
        LLHelper.printSLL(l2);
        LLHelper.printSLL(l3);
        LLHelper.printSLL(l4);

        SingleLLNode[] nodeList = { l1, l2, l3, l4 };

        System.out.println("After Merging");
        SingleLLNode merged = mergeKSorted(nodeList);
        LLHelper.printSLL(merged);

    }

    private static SingleLLNode mergeKSorted(SingleLLNode[] nodeList) {

        Comparator<Pair> comparator = Comparator.comparingInt(p -> (int) p.first);
        PriorityQueue<Pair<Integer, SingleLLNode>> pq = new PriorityQueue<>(comparator);

        for (SingleLLNode node : nodeList) {

            pq.add(new Pair<>(node.data, node));
        }

        SingleLLNode dummy = new SingleLLNode();
        SingleLLNode temp = dummy;

        while (!pq.isEmpty()) {
            Pair<Integer, SingleLLNode> it = pq.poll();
            if(it.second.next != null) {
                pq.add(new Pair<>(it.second.next.data, it.second.next));
            }
            temp.next = it.second;
            temp = temp.next;
        }
        return dummy.next;
    }
}

