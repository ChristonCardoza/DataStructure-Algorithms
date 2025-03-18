package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.SequencedMap;

public class LL23CopyNextRandom {

    public static void main(String[] args) {
        Integer[] arr = {7, 13, 11, 10, 1};
        SingleLLNode head = LLHelper.convertToLL(arr);
        LLHelper.printSLL(head);

        bruteforce(head);
        optimal(head);
    }

    private static SingleLLNode bruteforce(SingleLLNode head){

        SingleLLNode current = head;

        Map<SingleLLNode, SingleLLNode> map = new HashMap<SingleLLNode, SingleLLNode>();

        while(current != null){
            SingleLLNode newNode = new SingleLLNode(current.data);
            map.put(current, newNode);
            current = current.next;
        }

        current = head;

        while(current != null){
            SingleLLNode copyNode = map.get(current);
            copyNode.next = map.get(current.next);
            copyNode.random = copyNode.random;

            current = current.next;
        }

        return map.get(head);
    }

    private static SingleLLNode optimal(SingleLLNode head){

        // 1. Insert the copy node in between

        SingleLLNode current = head;

        while(current != null){
            SingleLLNode copyNode = new SingleLLNode(current.data);
            copyNode.next = current.next;
            current.next = copyNode;
            current = current.next.next;
        }


        // 2. Convert random pointer

        current = head;
        while(current != null){

            SingleLLNode copyNode =current.next;

            if(current.random !=null){
                copyNode.random = current.random.next;
            } else {
                copyNode.random = null;
            }

            current = current.next.next;
        }


        // 3. Convert next

        current = head;
        SingleLLNode dummy = new SingleLLNode(-1);
        SingleLLNode res = dummy;

        while(current != null){

            res.next = current.next;
            res = res.next;

            current.next = current.next.next;
            current = current.next;
        }

        return dummy.next;
    }
}
