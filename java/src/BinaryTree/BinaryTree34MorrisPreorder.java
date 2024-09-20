package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree34MorrisPreorder {

/*
        A prerequisite to this problem is Morris Inorder Traversal of Binary Tree. We extend Morris Inorder Traversal to Preorder Morris Traversal and modify the algorithm
        to print the current node’s value before moving to the left child when the right child of the inorder predecessor is null.

        This change ensures that the nodes are processed in the desired order for Preorder Traversal. The basic structure of Morris Traversal remains intact,
        but the printing step is adjusted, resulting in a Preorder Traversal that is still in-place and has a constant space complexity.
*/

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, null, null, null, null, 6} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        List<Integer> preOrder = morrisPreOrder(root);
        System.out.println(preOrder);
    }

    private static List<Integer> morrisPreOrder(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        TreeNode current = root;

        while(current != null){

            if(current.left == null){

                preOrder.add(current.key);
                current = current.right;

            } else {

                TreeNode prev = current.left;

                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = current;
                    preOrder.add(current.key);
                    current = current.left;
                } else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return preOrder;

    }
}
