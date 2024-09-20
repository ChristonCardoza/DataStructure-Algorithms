package BinaryTree;

import java.util.Stack;

public class BinaryTree36FlattenTree {

/*
     Given a Binary Tree, convert it to a Linked List where the linked list nodes follow the same order as the pre-order traversal of the binary tree.

     Use the right pointer of the Binary Tree as the ‘next’ pointer for the linked list and set the left pointer to null. Do this in place and do not create extra nodes.
*/

    static TreeNode prev = null;

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 3, 4, null, 6, null, null, null, null, 7} ;
        TreeNode root1 = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        TreeNode root2 = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        TreeNode root3 = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root1);

        System.out.println("\nRecursive Approach");
        flatRecurissive(root1);
        BinaryTreeUtil.printTree(root1);

        System.out.println("\nStack Approach");
        flatStack(root2);
        BinaryTreeUtil.printTree(root2);

        System.out.println("\nMorris Approach");
        flatMorris(root3);
        BinaryTreeUtil.printTree(root3);
    }

    private static void flatMorris(TreeNode root3) {

        TreeNode current = root3;

        while(current != null){

            if(current.left !=null){

                TreeNode prev = current.left;

                while(prev.right != null){
                    prev = prev.right;
                }

                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }

    }

    private static void flatStack(TreeNode root2) {

        Stack<TreeNode> st = new Stack<>();
        st.push(root2);

        while(!st.isEmpty()){

            TreeNode current = st.pop();

            if(current.right != null) st.push(current.right);

            if(current.left != null) st.push(current.left);

            if(!st.isEmpty()){
                current.right = st.peek();
            }

            current.left = null;
        }
    }

    public static void flatRecurissive(TreeNode root){

        if(root == null) return;

        flatRecurissive(root.right);
        flatRecurissive(root.left);


        root.right = prev;
        root.left = null;
        prev = root;
    }
}
