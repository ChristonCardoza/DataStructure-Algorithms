package StackQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SQ22SlidingWindowMax {

    /*
        nums = [ 1 3 -1 -3 5 3 2 1 6 ]            k =3
                 _____
                 3 ------
                   3 -------
                       5 -----
                         5 -----
                           5 -----
                             3 -----
                               6
     */

    class Pair<I extends Number, I1 extends Number> {

        int first, second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 2, 1, 6};
        int k = 3;

        System.out.println("Bruteforce Solution O(k * (n-k)): "+ bruteforce(nums, k));

        System.out.println("Optimal Solution O(2n): "+ optimal(nums, k));
    }

    private static List<Integer> bruteforce(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();

        for( int i=0; i< nums.length - k; i++) {
            int max = nums[i];

            for(int j=i; j<=i+k; j++) {
                max = Math.max(nums[j], max);
            }

            result.add(max);
        }
       ;return result;
    }

    private static List<Integer> optimal(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i =0; i<nums.length; i++) {

            // Remove indices that are out of the current window
            if(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.pollFirst();
            }

            // Remove indices whose corresponding values are smaller than nums[i]lllllkol.                                                        b
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index to the back of the deque
            dq.offerLast(i);

            // Add the maximum for the current window to the result list
            if(i >=k-1) result.add(nums[dq.peekFirst()]);
        }

        return result;
    }
}
