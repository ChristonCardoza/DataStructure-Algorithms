package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree07PostorderItr2Stack {
/*
                    1
                /       \
               2          3
              /  \       /
             4    5     6
                         \
                          7
                           \
                            8

        Left --> Right ---> Root

        4 5 2 8 7 6 3n1

        1) add root to stack 1
        2) pop from stack 1 and add it to stack 2
        3) add left and right to stack 1
        4) step 2 until stack empty
        5) pop all element of stack 2

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, null, null, null, 7, null, 8};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(postOrderItr2St(root));
    }


    public static List<Integer> postOrderItr2St(TreeNode node){

        List<Integer> postOrder =  new ArrayList<>();

        if(node == null) return postOrder;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.add(node);

        while(!st1.isEmpty()){
            node = st1.pop();
            st2.add(node);

            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }

        while(!st2.isEmpty()){
            postOrder.add(st2.pop().key);
        }

        return postOrder;
    }



}
