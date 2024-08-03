package BinaryTree;

public class BinaryTree13MaxPathSum {

    /*

        Val + MaxL + MaxR

                                  -10
                                  /  \                 15 + 20 + 17 = 42
                                 9   20             15 + 20 - 10 + 9 = 34
                                    // \\
                                   15    17

                        => 42

     */

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{-10, 9, 20, null, null, 15, 7 };
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        int[] maxPath = new int[1];

        maxPathSum(root, maxPath);

        System.out.println(maxPath[0]);
    }

    public static int maxPathSum(TreeNode node, int[] maxValue) {

        if(node == null) return 0;

        int left = Math.max(0, maxPathSum(node.left, maxValue));
        int right = Math.max(0, maxPathSum(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], left + right + node.key);

        return Math.max(left, right) + node.key;
    }
}
