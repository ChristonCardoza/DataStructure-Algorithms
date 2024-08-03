package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree09PreInPost {
    /*
                          1
                        /   \
                       2     3
                      /  \  /  \
                     4   5  6   7

           Pre-Order  : 1 2 4 5 3 6 7
           In-Order   : 4 2 5 1 6 3 7
           Post-Order : 4 5 2 6 7 3 1

     */

    static class Pair {

        TreeNode node;

        int val;

        Pair(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        ArrayList[]  result = preInPostTraversal(root);

        System.out.println("Pre Order: "+ result[0]);
        System.out.println("In Order: "+ result[1]);
        System.out.println("Post Order: "+ result[2]);
    }

    public static ArrayList[] preInPostTraversal(TreeNode node){

        ArrayList<Integer>[] result = new ArrayList[3];

        if(node == null) return result;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while(!st.isEmpty()){

            Pair it = st.pop();

            // Pre Order

            if(it.val == 1){

                pre.add(it.node.key);
                it.val ++;

                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left, 1));
                }

                // In Order
            } else if (it.val == 2){

                in.add((it.node.key));
                it.val ++;

                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right, 1));
                }

                // Post Order

            } else {
                post.add(it.node.key);
            }
        }

        return new ArrayList[] {pre,in, post};
    }
}
