package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST07KthLargest {

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 7, 1, 4, 6, 8, null, 2} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        int k = 5;
        System.out.println(getkthLargest(root, k));
    }

    private static int getkthLargest(TreeNode root, int k) {

        int[] largest = {-1, 0};

        reverseInorder(largest, root, k);

        return largest[0];
    }

    private static void reverseInorder(int[] largest, TreeNode node, int k) {

        if(node == null) return;

        reverseInorder(largest, node.right, k);

        largest[1] ++;
        if(largest[1] == k) {
            largest[0] = node.key;
            return;
        }

        reverseInorder(largest, node.left, k);
    }
}
