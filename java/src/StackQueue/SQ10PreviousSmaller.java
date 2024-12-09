package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ10PreviousSmaller {

    public static void main(String[] args) {

        int [] arr = {4, 5, 2, 10, 8};
        System.out.println("Bruteforce Solution  O(n^2): " + Arrays.toString(bruteforce(arr)));
        System.out.println("Optimal Solution  O(n): " + Arrays.toString(previousSmaller(arr)));
    }

    static int[] bruteforce(int[] arr) {

        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        for (int i= arr.length-1; i>=0; i--){

            for(int j=i-1; j>=0; j--) {

                if(arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }

        return result;
    }

    static int[] previousSmaller(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<arr.length; i++){

            while(!st.isEmpty() && st.peek() > arr[i]){
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return result;
    }
}
