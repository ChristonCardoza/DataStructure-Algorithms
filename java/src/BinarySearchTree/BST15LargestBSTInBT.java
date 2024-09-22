package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST15LargestBSTInBT {

    static class NodeValue {

        int maxNode, minNode, maxSize;

        NodeValue(int maxNode, int minNode, int maxSize){
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }


    }

    public static void main(String[] args) {
        Integer[] arr = {10, 5, 15, 1, 8, null, 7} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("Largest BST size: " + getLargetBST(root));
    }

    private static int getLargetBST(TreeNode root){
        return largestBST(root).maxSize;
    }

    private static NodeValue largestBST(TreeNode root){

        if(root == null) return  new NodeValue(0, Integer.MIN_VALUE, 0);

        // get values from left to right
        NodeValue left = largestBST(root.left);
        NodeValue right = largestBST(root.right);

        // current node greater than max in left and smaller than min in right
        if(left.maxNode < root.key && root.key < right.minNode){

            return new NodeValue(
                    Math.min(root.key, left.minNode),
                    Math.max(root.key, right.maxNode),
                    left.maxSize + right.maxSize + 1
            );
        }

        return  new NodeValue(
                Integer.MIN_VALUE,
               Integer.MAX_VALUE,
                 Math.max(left.maxSize, right.maxSize)
        );
    }
}
