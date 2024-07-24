package BinarySearch;

public class Search26RowWithMaxOnes {
/*
    You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
    Your task is to find the index of the row with the maximum number of ones.
    Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.

    mat = {
            Row 0 => { 0, 0, 1, 1, 1 },               => 3
            Row 1 => { 0, 0, 0, 0, 0 },               => 0
            Row 2 => { 0, 1, 1, 1, 1 },               => 4
            Row 3 => { 0, 0, 0, 0, 0 },               => 0
            Row 4 => { 0, 1, 1, 1, 1 },               => 4
    }

    Max one's present in Row 2 and Row 4 but min Row which has max one's is Row 2
 */

    public static void main(String[] args) {

        int[][] matrix =  new int[][]{
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1 },
        };

        System.out.println("Bruteforce Approach: ");
        System.out.println(bruteforceApproach(matrix));

        System.out.println("BinarySearch Approach: ");
        System.out.println(binarySearchApproach(matrix));

    }

    public static int bruteforceApproach(int[][] matrix){

        int n = matrix.length, m = matrix[0].length;
        int index = -1, maxCnt = -1;

        for(int i=0; i<n; i++){

            int countRow = 0;

            for(int j=0; j<m; j++){

                countRow += matrix[i][j];
            }

            if(countRow > maxCnt){
                maxCnt = countRow;
                index = i;
            }
        }

        return index;
    }

    public static int getLowerBound(int[] arr, int length, int key){

        // LowerBound arr[i] >= key  => i

        int low = 0, high = length-1;

        int lowerBound = length;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(arr[mid] >= key){
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }

    public static int binarySearchApproach(int[][] matrix){

        int n = matrix.length, m = matrix[0].length;
        int maxCount = -1, index= -1;

        for(int i=0; i<n; i++){

            int cntOnes = m - getLowerBound(matrix[i], m, 1);

            if(cntOnes > maxCount){
                maxCount = cntOnes;
                index = i;
            }
        }

        return index;
    }
}
