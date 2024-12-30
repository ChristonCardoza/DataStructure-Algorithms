package StackQueue;

import java.util.Stack;

public class SQ18LargestRectangleHistogram {

    /*

        area[i] = ( nse[i] - pse[i] - 1) * arr[i] => O(5N)

        arr[] = { 2, 1, 5, 6, 2, 3 }

        2 * 1 = 2
        1 * 6 = 6
        5 * 2 = 10   ---> Largest
        6 * 1 = 6
        2 * 4 = 8
        3 * 2 = 6
    */

    public static void main(String[] args) {

        int[] arr = { 2, 1, 5, 6, 2, 3 };

        System.out.println("Largest Rectangle: "+ largestRectangle(arr));
    }

    public static int largestRectangle(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<arr.length; i++) {

            while( !st.isEmpty() && arr[st.peek()] > arr[i]) {

                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 :  st.peek();

                maxArea = Math.max(arr[element] * (nse - pse -1), maxArea);
            }

            st.push(i);
        }

        while(!st.isEmpty()){

            int nse = arr.length;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(arr[element] * (nse - pse -1), maxArea);
        }

        return maxArea;
    }
}
