package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree23RootToNodePath {
/*
                                1               target = 7
                               / \
                              2   3
                             / \
                            4   5
                               / \
                              6   7

                      Path -> [1, 2, 5, 7]


 */
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        List<Integer> path = new ArrayList<>();
        getPath(root, 7, path);
        System.out.println(path);

    }

    public static boolean getPath(TreeNode node, int target, List<Integer> path){

        if(node == null) return  false;

        // add current node to the path
        path.add(node.key);

        if(node.key == target) return true;

        if(getPath(node.left, target, path) || getPath(node.right, target, path)){
            return true;
        }

        // remove current node from path
        path.removeLast();

        return false;

    }
}
