package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST03Floor {

    public static void main(String[] args) {

        Integer[] arr = {10, 5, 15, 2, 6} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("Floor of 7: " + findfloor(root, 7));
        System.out.println("Floor of 14: " + findfloor(root, 14));
    }

    private static int findfloor(TreeNode root, int target) {

        int floor = -1;

        while(root != null) {

            if( target < root.key){
                root = root.left;
            } else {

                floor = root.key;
                root = root.right;
            }
        }

        return floor;
    }
}
