package StackQueue;

import java.util.Stack;

public class SQ20RemoveKdigitSmallestNo {

 /*
     arr =  [1, 4, 3, 2, 2, 1, 9]  k = 3
                x  x  x

                keep smaller digit at  the start and get rid of larger

         =>    [1, 2, 1, 9]

  */

    public static void main(String[] args) {

        String no = "1432219";
        int k = 3;

        System.out.println("The smaller no is: " + reduce(no, k));
    }

    private static String reduce(String no, int k) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<no.length(); i++) {

            while(!st.isEmpty() && k>0 && ((st.peek() - '0') > (no.charAt(i) - '0'))){
                st.pop();
                k--;
            }

            st.push(no.charAt(i));
        }

        while(k>0) {
            st.pop();
            k--;
        }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        // Reverse the result since digits were appended in reverse order
        result.reverse();

        // Remove leading zeros, if any
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Return the final result
        return result.toString();
    }


}
