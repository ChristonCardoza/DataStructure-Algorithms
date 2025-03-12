package LinkedList;

public class LL16RemoveDuplicate {
    public static void main(String[] args) {
        Integer[] arr = {1, 1, 1, 2, 3, 4};
        DoubleLLNode root = LLHelper.convertToDLL(arr);
        LLHelper.printDLL(root);

        System.out.println("List after removing duplicates is : ");
        DoubleLLNode afterDelete =removeDuplicates(root);
        LLHelper.printDLL(afterDelete);
    }

    private static DoubleLLNode removeDuplicates(DoubleLLNode root) {

        DoubleLLNode current = root;

        while(current != null && current.next != null) {

            DoubleLLNode next = current.next;

            while(next != null && next.data == current.data) {

                next = next.next;
            }

            current.next = next;
            if(next != null) {
                next.prev = current;
            }

            current = current.next;
        }

        return root;
    }
}
