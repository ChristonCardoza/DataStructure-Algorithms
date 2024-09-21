package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST05DeleteNode {

    public static void main(String[] args) {

        Integer[] arr = {5, 3, 6, 2, 4, null, 7} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        root = deleteNode(root, 5);
        BinaryTreeUtil.printTree(root);

        root = deleteNode(root, 4);
        BinaryTreeUtil.printTree(root);

        root = deleteNode(root, 6);
        BinaryTreeUtil.printTree(root);
    }

    private static TreeNode deleteNode(TreeNode root, int target) {
        System.out.println("Deleting node " + target);
        if(root == null) return null;

        if(root.key == target) return deleteHelper(root);

        TreeNode dummy = root;

        while(root != null){

             if(root.key > target){

                 if( root.left != null && root.left.key == target){
                     root.left = deleteHelper(root.left);
                     break;
                 } else {
                     root = root.left;
                 }

             } else {

                 if( root.right != null && root.right.key == target){
                     root.right = deleteHelper(root.right);
                     break;
                 } else {
                     root = root.right;
                 }
             }
        }

        return dummy;
    }

    private static TreeNode deleteHelper(TreeNode node) {

        if( node.left == null){
            return node.right;
        } else if( node.right == null){
            return  node.left;
        } else {
            TreeNode rightChild = node.right;
            TreeNode leftLastRight = findLastRight(node.left);
            leftLastRight.right = rightChild;
            return node.left;
        }
    }

    private static TreeNode findLastRight(TreeNode node) {

        while(node.right !=null) {
            node = node.right;
        }

        return node;
    }
}
