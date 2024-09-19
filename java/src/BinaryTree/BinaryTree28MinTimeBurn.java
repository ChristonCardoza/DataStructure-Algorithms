package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTree28MinTimeBurn {

    /*
                                    1
                                   / \
                                  2   3              target = 2
                                 /   / \
                                4    5  6
                                 \
                                  7

            It takes 3 second to burn entire tree


     */

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, null, 5, 6, null, 7};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        int target = 2;
        TreeNode targetNode = getBurningNode(root, target);
        BinaryTreeUtil.printTree(targetNode);

        System.out.println(burnTree(root, targetNode));
    }

    private static TreeNode getBurningNode( TreeNode root, int target){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode burningNode = null;

        while(!queue.isEmpty()){

            TreeNode current = queue.poll();

            if(current.key == target){
                burningNode = current;
                break;
            }

            if(current.left != null) queue.offer(current.left);

            if(current.right != null) queue.offer(current.right);
        }

        return burningNode;

    }

    private static void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode current = queue.poll();

            if(current.left != null){
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }

            if(current.right != null){
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    private static int burnTree(TreeNode root, TreeNode burnNode){

        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParent(root, parentTrack);

        int burnTime = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(burnNode);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(burnNode, true);

        while(!queue.isEmpty()){

            int size = queue.size();
            boolean isNewBurn = false;

            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();

                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                    isNewBurn = true;
                }

                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                    isNewBurn = true;
                }

                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                    isNewBurn = true;
                }
            }

            if(isNewBurn) burnTime ++;

        }

        return burnTime;
    }
}
