package BinaryTree;

public class BinaryTree10MaxDepth {
    /*
                          1             -> 1
                        /   \
                       2     3          -> 2
                            /  \
                           4    6       -> 3
                          /
                         5              -> 4



     */
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, null, null, 4, 6, 5};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode node){

        if(node == null) return 0;

        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);

        return  1 + Math.max(lh, rh);
    }
}
