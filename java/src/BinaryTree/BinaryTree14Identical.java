package BinaryTree;

public class BinaryTree14Identical {

/*


                           1                         1
                         /   \                     /   \
                        2     3                   2     3
                             / \                       / \
                            4   5                     4   5


                                    => Identical

*/

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5 };
        TreeNode root1 = BinaryTreeUtil.createBinaryTreeFromArray(arr1);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5 };
        TreeNode root2 = BinaryTreeUtil.createBinaryTreeFromArray(arr2);

        System.out.println(isTreeIdentical(root1, root2));

    }

    public static boolean isTreeIdentical(TreeNode t1, TreeNode t2){

        if(t1 == null || t2 == null){

            return t1 == t2;
        }

        return t1.key == t2.key &&
                isTreeIdentical(t1.left, t2.left) &&
                isTreeIdentical(t1.right, t2.right);
    }
}
