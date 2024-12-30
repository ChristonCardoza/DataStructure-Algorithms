package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class SQ17AestroidCollision {

    /*
         arr = [ 4, 7, 1, 1, 2, -3, -7, 17, 15, -16]

         for +ve values move right
         for -ve values move left

         [ 4, 7, 1, 1, 2, -3 ]
                           | move left until u get greater value
                           [ 4, 7, -7, 17, 15, -16]
                                    |  move left until u get greater value
                                    :
                                    :
                                    [4,17] remains


     */
    public static void main(String[] args) {

        int[] arr = { 4, 7, 1, 1, 2, -3, -7, 17, 15, -16};

        System.out.println("Remaining Aestroid" + Arrays.toString(solution(arr)));
    }

    public static Object[] solution(int[] arr){
        Stack<Integer> st = new Stack<>();

        for( int i=0; i< arr.length; i++){

            if(arr[i] > 0) {
                st.push(arr[i]);
            } else {

                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])){
                    st.pop();
                }

                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])) {
                    st.pop();
                } else if( st.empty() || st.peek() < 0) {
                    st.push(arr[i]);
                }
            }
        }

        return st.toArray();
    }
}
