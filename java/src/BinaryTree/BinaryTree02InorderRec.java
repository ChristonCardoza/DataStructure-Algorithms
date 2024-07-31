package BinaryTree;

public class BinaryTree02InorderRec {

        /*
                          1
                        /   \
                       2     3
                      /  \  /  \
                     4   5  6   7

                 Left --> Root ---> Right

                  4 2 5 1 6 3 7

     */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2,3,4,5,6,7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        inOrder(root);
    }

    public static void inOrder(TreeNode node){

        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.key + "\t");
        inOrder(node.right);
    }
}
