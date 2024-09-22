package BinarySearchTree;

import BinaryTree.BinaryTreeUtil;
import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BST14Recover {

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, null, null, 2} ;
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        Map<String, TreeNode> memory = new HashMap<>();
        memory.put("first", null);
        memory.put("middle", null);
        memory.put("last", null);
        memory.put("prev", new TreeNode(Integer.MIN_VALUE));


        inorder(root, memory);

        if(memory.get("first") != null && memory.get("last") != null){
            swap(memory, "first", "last");

        } else if (memory.get("first") != null && memory.get("middle") != null) {
            swap(memory, "first", "middle");
        }


        BinaryTreeUtil.printTree(root);
    }

    public static void inorder(TreeNode root, Map<String, TreeNode> memory){


        if(root == null) return;

        inorder(root.left, memory);

        if(memory.get("prev") !=null && root.key < memory.get("prev").key){
            memory.put("first", memory.get("prev"));
            memory.put("middle", root);
        } else {
            memory.put("last", root);
        }
        memory.put("prev", root);

        inorder(root.right, memory);
    }

    public static void swap(Map<String, TreeNode> memory, String key1, String key2){
        Integer temp = memory.get(key1).key;
        memory.get(key1).key = memory.get(key2).key;
        memory.get(key2).key = temp;
    }
}
