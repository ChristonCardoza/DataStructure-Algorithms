package StackQueue;

import java.util.Arrays;

public class SQ23CelebrityProblem {

    /*

        Everyone should know him and he knows no one

        Known him = n-1
        he knows = 0
     */

    public static void main(String[] args) {

        int[][] mat = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println("Bruteforce O(n^2): " + bruteforce(mat));
        System.out.println("Optimal O(2n): " + optimal(mat));
    }

    private static int bruteforce(int[][] mat) {

        int n = mat.length;

        int[] knownHim = new int[n];
        int[] heKnows = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){

                if(mat[i][j] == 1) {
                    knownHim[j] ++;
                    heKnows[i] ++;
                }
            }
        }

        System.out.println("KnownHim: " + Arrays.toString(knownHim));
        System.out.println("HeKnows: " + Arrays.toString(heKnows));

        for(int i=0; i<n; i++){
            if(knownHim[i] == n-1 && heKnows[i] == 0) {
                return i;
            }
        }

        return -1;
    }

//    private static int optimal(int[][] mat) {
//        int top = 0;
//        int down  = mat.length-1;
//
//        while(top < down) {
//
//            if(mat[top][down] == 1) {
//                top = top + 1;
//            } else if(mat[down][top] == 1) {
//                down = down - 1;
//            } else {
//                top --;
//                down --;
//            }
//        }
//
//        if(top > down) {
//            return -1;
//        }
//
//        for(int i=0; i<mat.length; i++){
//
//            if(i==top) continue;
//
//            if(mat[top][i] == 0 && mat[i][top] == 1){
//
//            } else {
//                return -1;
//            }
//        }
//
//        return top;
//    }

    private static int optimal(int[][] mat) {
        int top = 0;
        int down = mat.length - 1;

        // Narrow down the potential celebrity
        while (top < down) {
            if (mat[top][down] == 1) {
                top++;
            } else {
                down--;
            }
        }


        /*
            After narrowing down to a single candidate (let's call it top), verify that:

            Candidate knows no one: For all j ≠ top, mat[top][j] must be 0.
            Everyone knows the candidate: For all i ≠ top, mat[i][top] must be 1.
            If either condition fails, there is no celebrity, and the function returns -1.
         */

        for (int i = 0; i < mat.length; i++) {
            if (i == top) continue;

            // Check if candidate knows no one and everyone knows them
            if (mat[top][i] == 1 || mat[i][top] == 0) {
                return -1;
            }
        }

        return top;
    }
}
