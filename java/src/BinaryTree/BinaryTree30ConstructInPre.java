package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree30ConstructInPre {

/*
                                           root
                                            |
                    inOrder = { 40, 20, 50, 10, 60, 30}   => Left Root Right

                    preOrder = {10, 20, 40, 50, 30 , 60}  => Root Left Right
                                 |
                                root

                                    root                 root
                                     |                    |
                    inOrder = { 40, 20, 50}        { 60, 30}

                   preOrder = { 20, 40, 50}        { 30 , 60}
                                |                     |
                                root                 root

* */

    public static void main(String[] args) {

        int[] preOrder = {10, 20, 40, 50, 30 , 60};
        int[] inOrder = { 40, 20, 50, 10, 60, 30};

        TreeNode root = costructTree(preOrder, inOrder);
        BinaryTreeUtil.printTree(root);
    }

    private static TreeNode costructTree(int[] preOrder, int[] inOrder) {

        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i=0; i<inOrder.length; i++){
            inMap.put(inOrder[i], i);
        }

        return buildTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1, inMap);
    }

    private static TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {

        if(preStart > preEnd || inStart > inEnd){

            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int inRoot = inMap.get(root.key);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot-1, inMap);
        root.right = buildTree(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
