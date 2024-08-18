package BinaryTree;

public class BinaryTree22Symmetry {

/*
                                1
                               / \
                              2   2
                             / \ / \
                            3  4 4  3

                         This is Symmetric

                                1
                               / \
                              2   2
                             / \ / \
                            3  4 3  4

                         This isn't Symmetric
*/
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        TreeNode root1 = BinaryTreeUtil.createBinaryTreeFromArray(arr1);
        BinaryTreeUtil.printTree(root1);
        System.out.println("Is Tree Symmetric: " + isTreeSymmetric(root1));

        Integer[] arr2 = new Integer[]{1, 2, 2, 3, 4, 3, 4};
        TreeNode root2 = BinaryTreeUtil.createBinaryTreeFromArray(arr2);
        BinaryTreeUtil.printTree(root2);
        System.out.println("Is Tree Symmetric: " + isTreeSymmetric(root2));
    }

    private static boolean isTreeSymmetric(TreeNode root) {

        return root == null || isTreeSymmetricHelper(root.left, root.right);
    }

    private static boolean isTreeSymmetricHelper(TreeNode left, TreeNode right) {

        if(left == null || right == null) return left == right;

        if(left.key != right.key) return false;

        return isTreeSymmetricHelper(left.left, right.right) && isTreeSymmetricHelper(left.right, right.left);
    }
}
