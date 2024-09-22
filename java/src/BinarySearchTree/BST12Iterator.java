package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

import java.util.Stack;

public class BST12Iterator {

    static class BSTIterator {

        private Stack<TreeNode> st = new Stack<>();

        BSTIterator(TreeNode root){
            pushAll(root);
        }

        void hasNext(){
            System.out.println(!st.isEmpty());
        }

        void next(){
            TreeNode temp = st.pop();
            pushAll(temp.right);
            System.out.println(temp.key);
        }

        void pushAll(TreeNode node){

            while(node !=null){
                st.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {7, 3, 10, 2, 6, 9, null, 1, null, 5, null, 8, null, null, null, 4} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        BSTIterator bstIterator = new BSTIterator(root);

        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.hasNext();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.hasNext();
    }


}
