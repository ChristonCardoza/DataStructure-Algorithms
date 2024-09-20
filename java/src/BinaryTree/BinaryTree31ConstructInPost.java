package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree31ConstructInPost {

    /*
                                           root
                                            |
                    inOrder = { 40, 20, 50, 10, 60, 30}   => Left Root Right

                    postOrder = {40, 50, 20, 60, 30, 10}  => Left Right Root
                                                     |
                                                    root

                                    root                 root
                                     |                    |
                    inOrder = { 40, 20, 50}        { 60, 30}

                   preOrder = { 40, 50, 20}        { 60 , 30}
                                        |                  |
                                       root               root

* */

    public static void main(String[] args) {

        int[] inOrder = {40, 20, 50, 10, 60, 30};
        int[] postOrder = {40, 50, 20, 60, 30, 10};

        TreeNode root = constructTree(inOrder, postOrder);
        BinaryTreeUtil.printTree(root);
    }

    private static TreeNode constructTree(int[] inOrder, int[] postOrder) {

        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i=0; i<inOrder.length; i++){
            inMap.put(inOrder[i], i);
        }

        return buildTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1, inMap);
    }

    private static TreeNode buildTree(int[] postOrder, int postStart, int postEnd, int[] inOrder, int intStart, int inEnd, Map<Integer, Integer> inMap){

        if(postStart > postEnd || intStart > inEnd){

            return  null;
        }

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int inRoot =  inMap.get(root.key);
        int numsLeft = inRoot - intStart;

        root.left = buildTree(postOrder, postStart, postStart + numsLeft -1, inOrder, intStart, inRoot - 1, inMap);
        root.right = buildTree(postOrder, postStart+ numsLeft, postEnd-1, inOrder, inRoot + 1, inEnd, inMap );

        return root;
    }
}
