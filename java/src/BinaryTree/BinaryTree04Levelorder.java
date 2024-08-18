package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree04Levelorder {
    /*
                      1 ----------------> Level 0
                    /   \
                   2     3 -------------> Level 1
                  /  \  /  \
                 4   5  6   7 ----------> Level 2


                Horizontal Printing

              1 2 3 4 5 6 7

              [[1], [2, 3], [4, 5, 6, 7]]

 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2,3,4,5,6,7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode node){

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(node == null) return wrapList;

        queue.offer(node);

        while (!queue.isEmpty()){

            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();


            for(int i=0; i<levelNum; i++){

                if(queue.peek().left != null) queue.offer(queue.peek().left);

                if(queue.peek().right != null) queue.offer(queue.peek().right);

                subList.add(queue.poll().key);
            }

            wrapList.add(subList);
        }

        return wrapList;
    }
}
