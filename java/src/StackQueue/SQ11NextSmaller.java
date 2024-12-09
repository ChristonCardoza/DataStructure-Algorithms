package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ11NextSmaller {

    public static void main(String[] args) {
        int [] arr = {4, 5, 2, 10, 8};
        System.out.println("Bruteforce Solution  O(n^2): " + Arrays.toString(bruteforce(arr)));
        System.out.println("Optimal Solution  O(n): " + Arrays.toString(nextSmaller(arr)));
    }


    static int[] bruteforce(int[] arr) {

        int[] result = new int[arr.length];

        Arrays.fill(result, -1);

        for(int i=0; i<arr.length; i++){

            for( int j=i+1; j<arr.length; j++) {

                if(arr[j] < arr[i]){

                    result[i] = arr[j];
                    break;
                }
            }
        }

        return result;
    }

    static int[] nextSmaller(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i= arr.length-1; i>=0; i--){

            // remove all smaller element than current
            while(!st.isEmpty() && st.peek() > arr[i]) {

                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return result;
    }
}
