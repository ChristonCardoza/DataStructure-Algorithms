package BinaryTree;

public class BinaryTree03PostorderRec {
/*
                      1
                    /   \
                   2     3
                  /  \  /  \
                 4   5  6   7

            Left --> Right ---> Root

              4 5 2 6 7 3 1

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2,3,4,5,6,7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        postOrder(root);
    }

    public static void postOrder(TreeNode node){

        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + "\t");
    }
}
