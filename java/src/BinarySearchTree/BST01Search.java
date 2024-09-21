package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST01Search {

    public static void main(String[] args) {
        Integer[] arr = {8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        int target = 10;
        BinaryTreeUtil.printTree(searchTree(root, target));
    }

    private static TreeNode searchTree(TreeNode root, int target) {

        while(root !=null && root.key != target) {

            root = target < root.key ? root.left : root.right;
        }

        return root;
    }
}
