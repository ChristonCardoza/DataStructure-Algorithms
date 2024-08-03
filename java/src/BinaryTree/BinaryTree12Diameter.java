package BinaryTree;

public class BinaryTree12Diameter {

    /*

        Path between any two nodes, path doesn't need to pass through the root

                                   1
                                //   \\
                               2     3
                                    /  \\
                                   4    5

                        => 3

                                   1
                                 /   \
                                2     3
                                    //  \\
                                   4      7
                                  //      \\
                                 5          8
                                //           \\
                               6               9

                       => 6

     */

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5 };
        TreeNode root1 = BinaryTreeUtil.createBinaryTreeFromArray(arr1);
        int [] diameter1 = new int[1];
        int [] diameter3 = new int[1];

        Integer[] arr2 = new Integer[]{1, 2, 3, null, null, 4, 7, 5, null, null, 8, 6, null, null, 7 };
        TreeNode root2 = BinaryTreeUtil.createBinaryTreeFromArray(arr2);
        int [] diameter2 = new int[1];
        int [] diameter4 = new int[1];

        System.out.println("Diameter of tree1 with bruteforce:" + diameterBruteforce(root1, diameter1));
        System.out.println("Diameter of tree2 with bruteforce:" + diameterBruteforce(root2, diameter2));

        diameterOptimal(root1, diameter3);
        System.out.println("Diameter of tree1 with optimal:" + diameter3[0]);
        diameterOptimal(root2, diameter4);
        System.out.println("Diameter of tree2 with optimal:" + diameter4[0]);
    }

    public static int diameterBruteforce(TreeNode node, int[] diameter){

        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        diameter[0] = Math.max(diameter[0], lh + rh);

        diameterBruteforce(node.left, diameter);
        diameterBruteforce(node.right, diameter);

        return diameter[0];
    }

    public static int height(TreeNode node){

        if(node == null) return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        return 1 + Math.max(lh, rh);
    }

    public static int diameterOptimal(TreeNode node, int[] diameter){

        if(node == null) return 0;

        int lh = diameterOptimal(node.left, diameter);
        int rh = diameterOptimal(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
