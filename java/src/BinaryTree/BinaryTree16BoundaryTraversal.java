package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree16BoundaryTraversal {
/*
                      1
                    /   \
                   2     3
                  /       \
                 3         8
                  \        /
                   4      9
                  / \    / \
                 8    6  10 11


           Clockwise: [1, 7, 8, 9, 11, 10, 6, 5, 4, 3, 2]

           Anti-Clockwise: [1, 2, 3, 4, 5, 6, 10, 11, 9, 8, 7]

 */

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 7, 3, null, null, 8, null, 4, 9, null, 5, 6, 10, 11};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        List<Integer> leftAnti = addLeftBoundary(root, false);
        List<Integer> leavesAnti = new LinkedList<>();
        addLeaves(root, leavesAnti, false);
        List<Integer> rightAnti = addRightBoundary(root, false);

        List<Integer> boundaryAnti = new LinkedList<>();
        boundaryAnti.add(root.key);
        boundaryAnti.addAll(leftAnti);
        boundaryAnti.addAll(leavesAnti);
        boundaryAnti.addAll(rightAnti);

        List<Integer> left = addLeftBoundary(root, true);
        List<Integer> leaves = new LinkedList<>();
        addLeaves(root, leaves, true);
        List<Integer> right = addRightBoundary(root, true);

        List<Integer> boundary = new LinkedList<>();
        boundary.add(root.key);
        boundary.addAll(right);
        boundary.addAll(leaves);
        boundary.addAll(left);

        System.out.println(" \n Clockwise: " + boundary);
        System.out.println(" \n Anti-Clockwise: " + boundaryAnti);

    }

    public static List<Integer> addLeftBoundary(TreeNode node, boolean isClock){

        List<Integer> res = new LinkedList<>();

        if( node == null) return res;

        TreeNode cur = node.left;

        while(cur != null){

            if(!isLeaf(cur)) {
                if (isClock) {
                    res.addFirst(cur.key);
                } else {
                    res.addLast(cur.key);
                }
            }

            cur = cur.left != null ? cur.left : cur.right;
        }

        return res;
    }

    public static List<Integer> addRightBoundary(TreeNode node, boolean isClock){

        List<Integer> res = new LinkedList<>();

        if( node == null) return res;

        TreeNode cur = node.right;

        while(cur != null){

            if(!isLeaf(cur)) {
                if (isClock) {
                    res.addLast(cur.key);
                } else {
                    res.addFirst(cur.key);
                }
            }

            cur = cur.right != null ? cur.right : cur.left;
        }

        return res;
    }

    public static void addLeaves(TreeNode node, List<Integer> res, boolean isClock){

        if(isLeaf(node)) {
            if (isClock) {
                res.addFirst(node.key);
            } else {
                res.addLast(node.key);
            }
            return;
        }

        if(node.left != null) addLeaves(node.left, res, isClock);

        if(node.right !=null) addLeaves(node.right, res, isClock);
    }

    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
