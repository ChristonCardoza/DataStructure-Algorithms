package BinaryTree;

import java.util.*;

public class BinaryTree27NodeAtDistanceK {
    /*
                                    3
                                   / \                                  k =v2
                                  5   1                                 target = 5
                                 / \  / \
                                6   2 0  8
                                   / \
                                  7   4

            Values which are at instance 2 from 5 : 7, 4, 1


     */
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = BinaryTreeUtil.createBinaryTreeFromArray(arr);
        BinaryTreeUtil.printTree(root);

        int target = 5;
        TreeNode targetNode = getTagetNode(root, target);
        int k = 2;

        System.out.println(distanceK(root, targetNode, 2));
    }

    private static void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }

            if(current.right != null){
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }

        }

    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k){

        List<Integer> result = new ArrayList<>();

        if(root == null) return  result;

        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParent(root, parentTrack);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);

        int currentLevel = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            if(currentLevel == k) break;

            currentLevel ++;

            for(int i=0; i<size; i++){

                TreeNode current = queue.poll();

                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }

        }

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            result.add(current.key);
        }

        return result;

    }

    private static TreeNode getTagetNode(TreeNode root, int target){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode targetNode = null;

        while(!queue.isEmpty()){

            TreeNode current = queue.poll();

            if(current.key == target) {

                targetNode = current;
                break;
            }

            if(current.left != null) queue.offer(current.left);

            if(current.right != null) queue.offer(current.right);
        }

        return targetNode;
    }
}
