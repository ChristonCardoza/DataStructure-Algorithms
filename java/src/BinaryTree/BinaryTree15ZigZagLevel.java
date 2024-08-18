package BinaryTree;

import java.util.*;

public class BinaryTree15ZigZagLevel {

    /*
                      1 ----------------> Level 0
                    /   \
                   2     3 -------------> Level 1
                  /  \  /  \
                 4   5  6   7 ----------> Level 2


                Horizontal Printing

              [[1], [2, 3], [4, 5, 6, 7]]  -> Normal Order

              [[1], [3, 2], [4, 5, 6, 7]]   -> Zig-Zag Order

 */

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2,3,4,5,6,7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(zigZagTraversal(root));

    }

    public static List<Deque<Integer>> zigZagTraversal(TreeNode root){

        List<Deque<Integer>> result = new ArrayList<>();

        if(root == null) return  result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){

            int levelSize = queue.size();
            Deque<Integer> row = new LinkedList<>();

            for(int i=0; i<levelSize; i++){

                TreeNode node = queue.poll();

                if (leftToRight) {
                    row.offerLast(node.key);
                } else {
                    row.offerFirst(node.key);
                }


                if(node.left != null) queue.offer(node.left);

                if(node.right != null) queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            result.add(row);

        }

        return result;
    }


}
