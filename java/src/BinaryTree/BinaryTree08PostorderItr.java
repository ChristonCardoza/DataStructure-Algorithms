package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree08PostorderItr {
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

        4 5 2 8 7 6 3 1

        1) Use a stack to keep track of nodes
        2) Use a pointer to track the last node that was visited
        3) Traverse the tree and push node to the stack until you reach the leftmost nodes
        4) Peek the node on the stack and check if it has  a right child or if the right child has already been visited.
           if it has right child and it hasn't been visited yet, move to the right child. Otherwise, visit the node and set it as the last visited node.

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, null, null, null, 7, null, 8};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(postOrderItr(root));
    }


//    public static List<Integer> postOrderItr(TreeNode node){
//        List<Integer> postOrder =  new ArrayList<>();
//
//        if(node == null) return postOrder;
//
//        Stack<TreeNode> st = new Stack<>();
//
//        TreeNode current = node;
//
//        while(current != null || !st.empty()){
//
//            if(current != null){
//
//                st.push(current);
//                current = current.left;
//
//            } else {
//
//                TreeNode temp = st.peek().right;
//
//                if(temp == null){
//
//                    temp = st.peek();
//                    st.pop();
//
//                    postOrder.add(temp.key);
//
//                    while(!st.isEmpty() && temp == st.peek().right){
//
//                        temp = st.peek();
//                        st.pop();
//
//                        postOrder.add(temp.key);
//                    }
//
//                } else {
//
//                    current = temp;
//                }
//            }
//        }
//
//        return postOrder;
//    }

    public static List<Integer> postOrderItr(TreeNode node){
        List<Integer> postOrder =  new ArrayList<>();

        if(node == null) return postOrder;

        Stack<TreeNode> st = new Stack<>();

        TreeNode current = node;
        TreeNode lastVisited = null;

        while(current != null || !st.empty()){

            // Reach left most node of current node
            while(current!=null){
                st.push(current);
                current = current.left;
            }

            // Peek the node
            TreeNode peekNode = st.peek();

            // If right node exists and traversing the node from left child move right
            if(peekNode.right != null && lastVisited != peekNode.right){
                current = peekNode.right;
            } else{
                // visit the node
                postOrder.add(peekNode.key);
                lastVisited = st.pop();
            }
        }

        return postOrder;
    }
}
