package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

import java.util.Stack;

public class BST13TwoSum {

    static class BSTIterator {

        private Stack<TreeNode> st = new Stack<>();
        private boolean reverse;

        BSTIterator(TreeNode root, boolean isReverse){
            reverse = isReverse;
            pushAll(root);
        }

        boolean hasNext(){
            return !st.isEmpty();
        }

        int next(){
            TreeNode temp = st.pop();

            if(reverse) pushAll(temp.left);
            else pushAll(temp.right);

            return temp.key;
        }

        void pushAll(TreeNode node){

            while(node !=null){
                st.push(node);
                if(reverse) node = node.right;
                else node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 6, 2, 4, null, 7} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        int sum = 9;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        boolean isTwoSum = false;

        while(i<j){

            if(i+j == sum) {
                isTwoSum = true;
                break;
            }
            else if (i+j < sum) {
                i = l.next();
            } else {
                j = r.next();
            }
        }

        System.out.println("Is 2 sum exist for sum 9: "+ isTwoSum);
    }
}
