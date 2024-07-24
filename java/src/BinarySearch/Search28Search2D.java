package BinarySearch;

public class Search28Search2D {
/*
    You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively.
    The elements of each row and each column are sorted in non-decreasing order.
    But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
    You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

    mat = {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 }
        }

    target = 14
 */

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };

        int target1 = 14;
        int target2 = 100;

        System.out.println(target1 + " : " + search(matrix, target1));
        System.out.println(target2 + " : " + search(matrix, target2));
    }

    public static boolean search(int[][] matrix, int target){

        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;

        while(row<n && col >=0){

            if(matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row ++;
            else col --;
        }

        return false;
    }
}
