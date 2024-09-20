package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree33MorrisInorder {

/*
    Morris Traversal is a tree traversal algorithm that allows for an in-order traversal of a binary tree without using recursion or a stack. It uses threading to traverse the tree efficiently.
    The key idea is to establish a temporary link between the current node and its in-order successor.

    The inorder predecessor of a node is the rightmost node in the left subtree. So when we traverse the left subtree, we encounter a node whose right child is null, this is the last node in that subtree.
    Hence, we observe a pattern whenever we are at the last node of a subtree such that the right child is pointing to none, we move to the parent of this subtree.
*/

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, null, null, null, null, 6} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        List<Integer> inOrder = morrisInOrder(root);
        System.out.println(inOrder);
    }

    private static List<Integer> morrisInOrder(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();

        TreeNode current = root;

        while (current != null){

            if(current.left == null){

                inOrder.add(current.key);
                current = current.right;

            } else {

                TreeNode prev = current.left;

                while(prev.right !=null && prev.right != current){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                } else {

                    prev.right = null;
                    inOrder.add(current.key);
                    current = current.right;
                }
            }
        }

        return inOrder;
    }
}
