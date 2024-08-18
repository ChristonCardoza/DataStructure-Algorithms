package BinaryTree;

import java.util.*;

public class BinaryTree19BottomView {
/*
                                   -2      -1       0       1       2
                                    +       +       +       +       +
                                    +       +       1       +       +
                                    +       +   /   +   \   +       +
                                    +       2       +       3       +
                                    +   /   +   \   +    /  +   \   +
                                    4       +      10   /   +      10
                                    +   \   +       9       +       +
                                    +       5       +       +       +
                                    +       +   \   +       +       +
                                    +       +       6       +       +


                                    4, 5, 6, 3, 10
 */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 10, 9, 10, null, 5, null, null, null, null, null, null, null, 6};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);
        System.out.println(bottomView(root));
    }

    public static class Pair {

        TreeNode first;
        int second;

        Pair(TreeNode first, int second){
            this.first = first;
            this.second = second;
        }
    }

    private static List<Integer> bottomView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){

            Pair it = queue.poll();

            TreeNode node =  it.first;
            int level = it.second;

            map.put(level, node.key);

            if(node.left != null) queue.offer(new Pair(node.left, level-1));

            if(node.right != null) queue.offer(new Pair(node.right, level+1));
        }

        ans.addAll(map.values());

        return ans;

    }
}