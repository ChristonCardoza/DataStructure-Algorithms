package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ09NextGreaterCircular {

    public static void main(String[] args) {
        int [] arr = {2, 10, 12, 1, 11};
        System.out.println("Bruteforce Solution  O(n^2): " + Arrays.toString(bruteforce(arr)));
        System.out.println("Optimal Solution  O(n): " + Arrays.toString(nextGreater(arr)));
    }


    static int[] bruteforce(int[] arr) {

        int[] result = new int[arr.length];

        Arrays.fill(result, -1);

        for(int i=0; i<arr.length; i++){

            for( int j=i+1; j< i+arr.length; j++) {

                int index = j % arr.length;

                if(arr[index] > arr[i]){

                    result[i] = arr[index];
                    break;
                }
            }
        }

        return result;
    }

    static int[] nextGreater(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        // assume hypothetical array ie append same array
        for(int i= 2 * arr.length-1; i>=0; i--){

            // remove all smaller element than current
            while(!st.isEmpty() && st.peek() <= arr[i % arr.length]) {

                st.pop();
            }

            // make changes only real array not imaginary copy
            if( i < arr.length) {
                result[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(arr[i % arr.length]);
        }

        return result;
    }
}
