package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree21RightSideView {
    /*

                                           1
                                         /    \
                                        2      3
                                      / \     / \
                                     4   10   9   10
                                      \
                                       5
                                        \
                                         6


                                       1, 3, 10
    */
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 10, 9, 10, null, 5, null, null, null, null, null, null, null, 6};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        System.out.println(result);
    }

    private static void rightView(TreeNode node, List<Integer> res, int level) {

        if (node == null) {
            return;
        }

        if(res.size() == level){
            res.add(node.key);

            rightView(node.right, res,level + 1);
            rightView(node.left, res, level+1);
        }

//        rightView(node.right, res,level + 1);
//        rightView(node.left, res, level+1);

    }
}
