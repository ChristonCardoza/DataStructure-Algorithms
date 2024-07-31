package BinaryTree;

public class BinaryTree01PreorderRec {
    /*
                          1
                        /   \
                       2     3
                      /  \  /  \
                     4   5  6   7

            Root --> Left ---> Right

            1 2 4 5 3 6 7

     */
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        preOrder(root);

    }

    public static void preOrder(TreeNode node){

        if(node == null) return;

        System.out.print(node.key + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }
}
