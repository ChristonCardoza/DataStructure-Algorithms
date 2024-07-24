package BinarySearch;

public class Search27Search2D {
/*
    You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively.
    The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists).
    You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

    mat = {
            { 3, 4, 7, 9 },
            {12, 13, 16, 18 },
            {20, 21, 23, 28 }
          }

    target = 23

    convert 2D array into imaginary 1D array and perform BS
    row = index/m
    col = index%m

    Ex: Index 5 contains the value 13, 5/4 = 1
                                       5%4 = 1 , so it is located at (1,1)
 */

    public static void main(String[] args) {

        int[][] matrix =  {
                { 3, 4, 7, 9 },
                {12, 13, 16, 18 },
                {20, 21, 23, 28 }
        };

        int target1 = 23;
        int target2 = 100;

        System.out.println(target1 + " : " +search(matrix, target1));
        System.out.println(target2 + " : " +search(matrix, target2));
    }

    public static boolean search(int[][] matrix, int target){

        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = (n * m) - 1;

        while(low <= high){

            int mid = low + (high-low)/2;

            int row = mid/m, col = mid % m;

            if( matrix[row][col] == target) return true;

            else if ( matrix[row][col] < target) low = mid + 1;

            else high = mid - 1;
        }

        return false;
    }
}
