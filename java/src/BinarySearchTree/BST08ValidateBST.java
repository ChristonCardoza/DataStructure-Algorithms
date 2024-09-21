package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST08ValidateBST {

    public static void main(String[] args) {

        Integer[] arr = {13, 10, 15, 7, 12, 14, 17, null, 9, null, null, null, null, 16, null, 8} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {

        if(root == null) {
            return true;
        }

        if(root.key >= maxValue || root.key <= minValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.key) && isValidBST(root.right, root.key, maxValue);
    }


}
