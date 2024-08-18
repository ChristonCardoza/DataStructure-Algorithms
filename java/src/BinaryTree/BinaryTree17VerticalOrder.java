package BinaryTree;

import java.util.*;

public class BinaryTree17VerticalOrder {

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

                                    [[4], [2, 5], [1, 10, 9, 6], [3], [10]]
*/

    static class Tupple {

        TreeNode node;
        int row;
        int col;

        public Tupple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 10, 9, 10, null, 5, null, null, null, null, null, null, null, 6};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);
        System.out.println();

        System.out.println(findVerticalOrder(root));

    }

    public static List<List<Integer>> findVerticalOrder(TreeNode root){

        if (root == null) {
            return new ArrayList<>();
        }

        // Vertical node and level information
        Map<Integer, Map<Integer, ArrayList<Integer>>> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Tupple> queue = new LinkedList<>();

        queue.offer(new Tupple(root, 0, 0));

        while(!queue.isEmpty()){

            Tupple tupple = queue.poll();
            TreeNode node = tupple.node;
            int x = tupple.row;
            int y = tupple.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,  new ArrayList<>());
            }
            map.get(x).get(y).add(node.key);

            if(node.left != null){
                queue.offer(new Tupple(node.left, x-1, y+1));
            }

            if (node.right != null) {

                queue.offer((new Tupple(node.right, x+1, y+1)));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer, Map<Integer, ArrayList<Integer>>> entry : map.entrySet()){

            List<Integer> verticals = new ArrayList<>();

            for( ArrayList<Integer> list: entry.getValue().values()){
                verticals.addAll(list);
            }

            ans.add(verticals);
        }

        return ans;
    }
}
