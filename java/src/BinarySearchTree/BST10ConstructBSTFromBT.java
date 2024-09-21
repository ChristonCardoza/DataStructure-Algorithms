package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

public class BST10ConstructBSTFromBT {
    public static void main(String[] args) {
        Integer[] preOrder = {8, 5, 1, 7, 10, 12} ;

        TreeNode bst = bstFromPreOrder(preOrder, Integer.MAX_VALUE, new int[]{0});
        System.out.println("Constructed BST is: ");
        BinaryTreeUtil.printTree(bst);

    }

    private static TreeNode bstFromPreOrder(Integer[] preOrder, int maxValue, int[] count) {

        if(count[0] == preOrder.length || preOrder[count[0]] > maxValue){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[count[0]++]);
        root.left = bstFromPreOrder(preOrder, root.key, count);
        root.right = bstFromPreOrder(preOrder, maxValue, count);

        return root;
    }
}
