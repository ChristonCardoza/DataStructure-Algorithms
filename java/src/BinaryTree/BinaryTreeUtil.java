package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int value){
        key = value;
        left = right = null;
    }
}


public class BinaryTreeUtil {

    public static TreeNode root = null;

    public static TreeNode createBinaryTreeFromArray(Integer[] arr){

        if(arr.length == 0 || arr[0] == null){
            return new TreeNode(-1);
        }

        root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while(i < arr.length){

            TreeNode current = queue.poll();

            if(i < arr.length && arr[i] != null){
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if(i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
