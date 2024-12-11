package StackQueue;

import java.util.Stack;

public class SQ14SumOfSubArrayMinimum {

    public static void main(String[] args) {

        int[] arr = { 3, 1, 2, 4};

        System.out.println("Bruteforce Approach O(n^2): " + bruteforce(arr));

    }

    public static int bruteforce(int[] arr){

        int sum = 0;

        for (int i=0; i<arr.length; i++) {

            int min = arr[i];

            for(int j= i; j<arr.length; j++) {

                min = Math.min(min, arr[j]);
                sum = sum + min;
            }

        }

        return sum;
    }

    /*
         idx ->    0        1        2        3        4        5        6         7
                   1        4        6        7        3        7        8         1
                                                       |
                            |__________________________|_________________|

        3 is minimum                   4 left               3 right

        total = 3 * 4 => 12 sub-arrays

        contribution of 3 in total ans in 12 sub-arrays = 12 * 3 => 36

        for index 4 having value 3 the next smaller value is 1 at index 7
        so element on right = 7-4 => 3

        for index 4 having value 3 the previous smaller value is 0 at index 0
        so element on left = 4-0 => 4
     */
    public static int optimal(int[] arr) {

        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        int total = 0;

        for (int i=0; i<arr.length; i++) {

            int left = i - pse[i];
            int right = nse[i] - i;

            total = total + (right * left * arr[i]);
        }

        return total;
    }

    private static int[] findPSE(int[] arr) {

        int[] pse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty()? -1 : st.peek();

            st.push(i);
        }

        return pse;
    }

    private static int[] findNSE(int[] arr) {

        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {

                st.pop();
            }

            nse[i] = st.isEmpty() ? arr.length : st.peek();

            st.push(i);
        }

        return nse;
    }


}
