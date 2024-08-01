package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree06InorderItr {
/*
                  1
                /   \
               2     3
              /  \
             4    5
                 /  \
                 6   7

        Left --> Root ---> Right

        4 2 6 5 7 1 3

        1) add root to stack
        2) add left to the stack, if not exist pop
        3) add right to stack, if not pop

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(inOrderItr(root));
    }

    public static List<Integer> inOrderItr(TreeNode node){

        List<Integer> inOrder = new ArrayList<>();

        if(node == null) return inOrder;

        Stack<TreeNode> st = new Stack<>();

        while(true){


            if(node != null){
                st.push(node);
                // travel to left most node
                node = node.left;
            } else {

                if(st.isEmpty()){
                    break;
                }

                node = st.pop();
                inOrder.add(node.key);

                // go to right
                node = node.right;
            }
        }

        return inOrder;
    }
}
