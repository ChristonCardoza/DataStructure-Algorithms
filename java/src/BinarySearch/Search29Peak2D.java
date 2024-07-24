package BinarySearch;

import java.util.Arrays;

public class Search29Peak2D {
/*
    A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

    Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

    You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

    You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

    matrix = {
                { -1, -1, -1, -1, -1 },
                { -1, 10, 20, 15, -1 },
                { -1, 21, 30, 14, -1 },
                { -1, 7,  16, 32, -1 },
                { -1, -1, -1, -1, -1 },
        }

         Both 30 and 32 are peak elements
 */

    public static void main(String[] args) {

        int[][] matrix = {
                { -1, -1, -1, -1, -1 },
                { -1, 10, 20, 15, -1 },
                { -1, 21, 30, 14, -1 },
                { -1, 7,  16, 32, -1 },
                { -1, -1, -1, -1, -1 },
        };

        System.out.println(Arrays.toString(findPeak(matrix)));
    }

    public static int findMaxIndex(int[][] matrix, int n, int m, int col){

        int maxVal =- 1, index = -1;

        for(int i=0; i<n; i++){

            if(matrix[i][col] > maxVal){
                maxVal = matrix[i][col];
                index = i;
            }
        }

        return index;
    }

    public static int[] findPeak(int[][] matrix){

        int n = matrix.length, m = matrix[0].length;

        int low = 0, high = m-1;

        while(low <= high){

            int mid = low + (high-low)/2;

            int maxRowIndex = findMaxIndex(matrix, n, m, mid);

            int left = mid-1 >=0 ? matrix[maxRowIndex][mid-1] : -1;
            int right = mid+1 <m ? matrix[maxRowIndex][mid+1] : -1;

            if(matrix[maxRowIndex][mid] > left && matrix[maxRowIndex][mid] > right){

                return new int[]{maxRowIndex, mid};

            } else if(matrix[maxRowIndex][mid] < left){

                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }


}
