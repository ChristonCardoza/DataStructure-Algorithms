package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST02Ceil {

    public static void main(String[] args) {

        Integer[] arr = {10, 5, 13, 3, 6, 11, 14, 2, 4, null, 9} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("Ceil of 8: " + findCeil(root, 8));
        System.out.println("Ceil of 11: " + findCeil(root, 11));
        System.out.println("Ceil of 12: " + findCeil(root, 12));
    }

    private static int findCeil(TreeNode root, int target) {

        int ceil = -1;

        while (root != null){

            if(target <= root.key) {
                ceil = root.key;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }
}
