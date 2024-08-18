package BinaryTree;

public class BinaryTree24LowestCommonAncestor {
/*
                                1
                               / \
                              2   3
                             / \  / \
                            4   5 8  9
                               / \
                              6   7

                      lca(4,7) => 2
                      lca(5,9) => 1
                      lca(2,6) => 2

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 8, 9, null, null, 6, 7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        System.out.println("LCA(4,5) : " +  getLowestCommonAncestor(root, 4, 7).key);
        System.out.println("LCA(5,9) : " +  getLowestCommonAncestor(root, 5, 9).key);
        System.out.println("LCA(2,6) : " +  getLowestCommonAncestor(root, 2, 6).key);
    }

    public static TreeNode getLowestCommonAncestor(TreeNode node, int p, int q){

        if(node == null || node.key == p || node.key == q) return node;

        TreeNode left = getLowestCommonAncestor(node.left, p, q);
        TreeNode right = getLowestCommonAncestor(node.right, p, q);

        if(left == null) return right;
        else if (right == null) return left;
        else return node; // when both node are not null, ans lies in node

    }
}
