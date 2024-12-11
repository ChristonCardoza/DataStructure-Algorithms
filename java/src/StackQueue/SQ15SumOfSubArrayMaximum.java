package StackQueue;

import java.util.Stack;

public class SQ15SumOfSubArrayMaximum {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4};

        System.out.println("Bruteforce Approach O(n^2): " + bruteforce(arr));
        System.out.println("Optimal Approach O(5n): " + optimal(arr));
    }

    public static int bruteforce(int[] arr) {

        int sum = 0;

        for( int i=0; i<arr.length; i++) {

            int max = arr[i];

            for(int j=i; j<arr.length; j++) {

                max = Math.max(max, arr[j]);
                sum = sum + max;
            }
        }

        return sum;
    }

    public static int optimal(int[] arr) {

        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        int total = 0;

        for(int i=0; i<arr.length; i++) {

            int left = i - pge[i];
            int right = nge[i] - i;

            total = total +  (left * right * arr[i]);
        }

        return total;
    }

    private static int[] findPGE(int[] arr) {

        int[] pge = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<arr.length; i++) {

            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }


        return pge;
    }

    private static int[] findNGE(int[] arr) {

        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){

            while( !st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }

            nge[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }

        return nge;
    }
}
