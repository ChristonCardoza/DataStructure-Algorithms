package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree35MorrisPostorder {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, null, null, null, null, 6} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        List<Integer> postOrder = morrisPostOrder(root);
        System.out.println(postOrder);
    }

    private static List<Integer> morrisPostOrder(TreeNode root) {

        List<Integer> postOrder = new ArrayList<>();

        TreeNode current = root;

        while(current!=null){

            if(current.right == null){

                postOrder.add(current.key);
                current = current.left;

            } else {

                TreeNode prev = current.right;

                while(prev.left !=null && prev.left != current){
                    prev = prev.left;
                }

                if(prev.left == null){
                    prev.left = current;
                    postOrder.add(current.key);
                    current = current.right;
                } else {
                    prev.left = null;
                    current = current.left;
                }
            }
        }

        return postOrder.reversed();
    }
}
