package BinaryTree;

public class BinaryTree26ChildrenSum {

/*
       Given a Binary Tree, convert the value of its nodes to follow the Children Sum Property.
       The Children Sum Property in a binary tree states that for every node, the sum of its children's values (if they exist)
       should be equal to the node's value. If a child is missing, it is considered as having a value of 0.

       Note:
            The node values can be increased by any positive integer any number of times, but decrementing any node value is not allowed.
            A value for a NULL node can be assumed as 0.
            We cannot change the structure of the given binary tree.


                                2                                               50
                               / \                                             / \
                              35  10                  =>                      38  12
                             / \  / \                                        / \  / \
                            2   3 5  2                                      35  3 10  2
 */

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{2, 35, 10, 2, 3, 5, 2};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("Performing Children Sum");
        changeTree(root);

        BinaryTreeUtil.printTree(root);
    }

    private static void changeTree(TreeNode root) {

        if(root == null){
            return;
        }

        int child = 0;

        if(root.left != null) child+= root.left.key;

        if(root.right != null) child+= root.right.key;

        if(child >= root.key) {
            root.key = child;
        } else {
            if(root.left != null) root.left.key = root.key;
            else if(root.right !=null) root.right.key = root.key;
        }

        changeTree(root.left);
        changeTree(root.right);

        // leaf node
        int total = 0;

        if(root.left != null) total += root.left.key;

        if(root.right != null) total += root.right.key;

        // if either of child exists
        if(root.left != null || root.right != null) root.key = total;

    }


}
