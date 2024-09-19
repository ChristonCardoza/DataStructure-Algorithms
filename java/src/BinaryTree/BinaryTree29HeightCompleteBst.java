package BinaryTree;

public class BinaryTree29HeightCompleteBst {

 /*
                             1
                           /    \
                          2      3
                         / \    / \
                        4  5    6  7
                       / \ | \
                      8  9 10 11


                          2
                         / \
                        4   5                            lh = 3  rh = 3
                       / \  | \                          lh == rh => 2^h-1    => 7
                      8  9  10 11


                          3
                         / \                              lh = 2  rh = 2
                         6  7                             lh == rh => 2^h-1    => 3


                    lh != rh  => 1 + lh + rh     => 1 + 7 + 3 => 11


*/

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root){

        if(root == null) {

            return 0;
        }

        int lh = findHeightLeft(root);
        int rh = findHeightRight(root);

        // all leaves are in same level then perfect binary tree nodes = 2^h-1
        if(lh == rh) return (1<<lh)-1;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private static int findHeightLeft(TreeNode node){

        int height = 0;

        while(node!=null){
            height ++;
            node = node.left;
        }

        return height;
    }

    private static int findHeightRight(TreeNode node){

        int height = 0;

        while(node!=null){
            height ++;
            node = node.right;
        }

        return height;
    }
}
