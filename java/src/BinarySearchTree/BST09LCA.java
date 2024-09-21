package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST09LCA {

    public static void main(String[] args) {
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("LCA of (2,5): " + getLCA(root, 2, 5));
        System.out.println("LCA of (0,9): " + getLCA(root, 0, 9));
        System.out.println("LCA of (7,9): " + getLCA(root, 7, 9));
    }

    private static int getLCA(TreeNode root, int a, int b) {

        if(root == null) return -1;

        TreeNode current = root;

        if(current.key < a && current.key < b){
            return getLCA(root.right, a, b);
        }

        if(current.key > a && current.key > b){
            return  getLCA(root.left, a, b);
        }

        return current.key;
    }
}
