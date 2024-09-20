package BinaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class binaryTree32SerializeDeserialize {

    public static void main(String[] args) {

        Integer arr[] = {1, 2, 3, null, null, 4, 5};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        String serialize = serializeTree(root);
        System.out.println("Serialize Tree: "+ serialize);
        TreeNode deserialize = desrializeTree(serialize);
        System.out.println("De-Serialize Tree: ");
        BinaryTreeUtil.printTree(deserialize);
    }

    private static TreeNode desrializeTree(String serialize) {
        if(Objects.equals(serialize, "")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = serialize.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for(int i=1; i<values.length; i=i+2){

            TreeNode parent = queue.poll();

            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!values[i+1].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i+1]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    private static String serializeTree(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current == null) {
                res.append("n ");
                continue;
            }

            res.append(current.key + " ");

            queue.offer(current.left);
            queue.offer(current.right);

        }

        return res.toString();
    }
}
