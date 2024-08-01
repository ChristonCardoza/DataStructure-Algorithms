package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree05PreorderItr {
/*
                  1
                /   \
               2     7
              /  \
             3    4
                 /  \
                 5   6

        Root --> Left ---> Right

        1 2 3 4 5 6 7

        1) add root to stack and pop it
        2) add right first then left to stack

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 7, 3, 4, null, null, null, null, 5, 6};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(preOrderItr(root));
    }

    public static List<Integer> preOrderItr(TreeNode node){

        List<Integer> preOrder = new ArrayList<>();

        if(node == null) return preOrder;

        Stack<TreeNode> st = new Stack<>();
        st.push(node);

        while(!st.isEmpty()){
            node = st.pop();
            preOrder.add(node.key);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }

        return preOrder;
    }
}
