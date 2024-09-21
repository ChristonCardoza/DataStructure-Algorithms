package BinaryTree;

import java.util.*;


public class BinaryTreeUtil {

    public static TreeNode root = null;

    public static TreeNode createBinaryTreeFromArray(Integer[] arr){

        if(arr.length == 0 || arr[0] == null){
            return null;
        }

        root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while(i < arr.length){

            TreeNode current = queue.poll();

            if(i < arr.length && arr[i] != null){
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if(i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }


    private static TreeNode buildTreefromLevel(List<List<Integer>> levelOrder) {
        if (levelOrder == null || levelOrder.isEmpty()) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder.get(0).get(0));
        queue.offer(root);

        int i = 1;
        while (i < levelOrder.size()) {
            List<Integer> level = levelOrder.get(i);
            int index = 0;
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();

                if (index < level.size()) {
                    node.left = new TreeNode(level.get(index++));
                    queue.offer(node.left);
                }
                if (index < level.size()) {
                    node.right = new TreeNode(level.get(index++));
                    queue.offer(node.right);
                }
            }
            i++;
        }

        return root;
    }


    public static void printTree(TreeNode root) {
        if (root == null) return;

        int maxLevel = getMaxLevel(root);
        printNodeInternal(root, 1, maxLevel, new int[maxLevel], new boolean[maxLevel], true);
    }

    private static void printNodeInternal(TreeNode node, int level, int maxLevel, int[] branchDirections, boolean[] isLast, boolean isRoot) {
        if (node == null) return;

        if (level > 1) {
            for (int i = 1; i < level - 1; i++) {
                if (isLast[i - 1]) {
                    System.out.print("     ");
                } else {
                    System.out.print("│    ");
                }
            }
            if (isRoot) {
                System.out.println("     " + node.key);
            } else if (branchDirections[level - 2] == 0) {
                System.out.println("└── " + node.key);
            } else {
                System.out.println("┌── " + node.key);
            }
        } else {
            System.out.println(node.key);
        }

        if (node.left != null || node.right != null) {
            branchDirections[level - 1] = 1;
            isLast[level - 1] = node.right == null;
            printNodeInternal(node.left, level + 1, maxLevel, branchDirections, isLast, false);

            branchDirections[level - 1] = 0;
            isLast[level - 1] = true;
            printNodeInternal(node.right, level + 1, maxLevel, branchDirections, isLast, false);
        }
    }

    private static int getMaxLevel(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getMaxLevel(root.left), getMaxLevel(root.right)) + 1;
    }

}
