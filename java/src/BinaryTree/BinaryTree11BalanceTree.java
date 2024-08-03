package BinaryTree;

public class BinaryTree11BalanceTree {

    /*

        For every node absolute difference between left height and right height

                                  1     (balance) (1,2)
                                /   \
             (balanced)  (0,0) 2     3  (balance) (1,1)
                                    /  \
                                   4    6
                        (balance) (0,0)    (balance) (0,0)


                                       1 (un balance) (3,1)
                                     /   \
                  (balanced) (2,1)  3     2 (balanced) (0,0)
                                  /   \
                (balance) (1,1)  5     4 (balance) (0,0)
                               /   \
             (balance) (0,0)  7     6 (balance) (0,0)



     */

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1, 2, 3, null, null, 4, 6 };
        TreeNode root1 = BinaryTreeUtil.createBinaryTreeFromArray(arr1);

        System.out.println(isTreeBalanced(root1) == -1 ? "Tree is not balanced" : "Tree is balance");

        Integer[] arr2 = new Integer[]{1, 3, 2, 5, 4, null, null, 7, 6 };
        TreeNode root2 = BinaryTreeUtil.createBinaryTreeFromArray(arr2);

        System.out.println(isTreeBalanced(root2) == -1 ? "Tree is not balanced" : "Tree is balance");
    }

    public static int isTreeBalanced(TreeNode node) {

        if(node == null) return 0;

        int lh = isTreeBalanced(node.left);
        if(lh == -1) return -1;

        int rh = isTreeBalanced(node.right);
        if(rh == -1) return -1;

        // check tree balance
        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}
