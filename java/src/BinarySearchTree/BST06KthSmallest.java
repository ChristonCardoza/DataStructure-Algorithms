package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST06KthSmallest {

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 7, 1, 4, 6, 8, null, 2} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        int k = 5;
        System.out.println(getKthSmallest(root,k));
    }

    private static int getKthSmallest(TreeNode root, int k) {

        int[] smallest = {-1, 0};

        smallestHelper(smallest, root, k);

        return smallest[0];

    }

    private static void smallestHelper(int[] smallest, TreeNode node, int k) {

        if(node == null) return;

        smallestHelper(smallest, node.left, k);

        smallest[1]++;
        if(smallest[1] == k) {
            smallest[0] = node.key;
            return;
        }

        smallestHelper(smallest, node.right, k);
    }
}
