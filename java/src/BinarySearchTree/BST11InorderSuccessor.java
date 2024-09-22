package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST11InorderSuccessor {

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 7, 2, 4, 6, 9, 1, null, null, null, null, null, 8, 10} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("Inorder Successor of 8: " + inorderSuccessor(root, 8));
        System.out.println("Inorder Successor of 2: " + inorderSuccessor(root, 2));
    }

    private static int inorderSuccessor(TreeNode root, int target) {

        int successor = -1;

        while(root != null){

            if(target >= root.key){
                root = root.right;
            } else {
                successor = root.key;
                root = root.left;
            }
        }

        return successor;
    }
}
