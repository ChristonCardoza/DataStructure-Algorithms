package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST04InsertNode {

    public static void main(String[] args) {

        Integer[] arr = {4, 2, 7, 1, 3} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        TreeNode newNode = new TreeNode(5);
        System.out.println("Inserting node 5");
        BinaryTreeUtil.printTree(insertNode(root, newNode));
    }

    private static TreeNode insertNode(TreeNode root, TreeNode newNode) {

        if(root == null) return newNode;

        TreeNode current = root;

        while(true){

            if(current.key <= newNode.key){

                if(current.right != null) {
                    current = current.right;
                }else {
                    current.right = newNode;
                    break;
                }
            } else {

                if(current.left != null){
                    current = current.left;
                } else {

                    current.left = newNode;
                    break;
                }
            }
        }

        return root;
    }
}
