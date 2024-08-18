package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree25MaxWidth {

/*
                                   Max no of nodes in a level between any 2 nodes


                    1                                   1                                     1                         -------> Level 0
                   / \                                 / \                                   / \
                  3   2                               3   2                                 3   2                       -------> Level 1
                 / \   \                             /     \                               /
                5   3   4                           5       4                             5                             -------> Level 2
                                                   /         \
                                                  7           6                                                         -------> Level 3

             Max Width of Tree is: 4             Max Width of Tree is: 8                 Max Width of Tree is: 2


                                        i
                                       / \
                                    2i+1  2i+2
 */

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 3, 2, 5, 3, null, 4};
        TreeNode root1 = BinaryTreeUtil.createBinaryTreeFromArray(arr1);
        BinaryTreeUtil.printTree(root1);
        System.out.println("Max Width of Tree is: " + getMaxWidth(root1));

        Integer[] arr2 = new Integer[]{1, 3, 2, 5, null, null, 4, 7, null, null, 6};
        TreeNode root2 = BinaryTreeUtil.createBinaryTreeFromArray(arr2);
        BinaryTreeUtil.printTree(root2);
        System.out.println("Max Width of Tree is: " + getMaxWidth(root2));

        Integer[] arr3 = new Integer[]{1, 3, 2, 5};
        TreeNode root3 = BinaryTreeUtil.createBinaryTreeFromArray(arr3);
        BinaryTreeUtil.printTree(root3);
        System.out.println("Max Width of Tree is: " + getMaxWidth(root3));
    }

    public static class Pair {

        TreeNode first;
        int second;

        Pair(TreeNode first, int second){
            this.first = first;
            this.second = second;
        }
    }

    private static int getMaxWidth(TreeNode root) {

        if(root == null) return 0;

        int ans = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){

            int size = q.size();
            int min = q.peek().second;
            int first = 0; int last = 0;

            for(int i=0; i<size; i++){

                int current = q.peek().second - min;
                TreeNode node = q.peek().first;
                q.poll();

                if(i == 0) first = current;
                if(i== size-1) last = current;

                if(node.left != null) q.offer(new Pair(node.left, current * 2 + 1));
                if(node.right != null) q.offer(new Pair(node.right, current*2 + 2));

            }

            ans = Math.max(ans, last-first+1);
        }

        return ans;
    }


}
