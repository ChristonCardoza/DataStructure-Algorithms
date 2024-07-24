package BinarySearch;

public class Search30Median2D {
/*
    Given a row-wise sorted matrix of size MXN, where M is no. of rows and N is no. of columns, find the median in the given matrix.

    Note: MXN is odd.

    matrix = {
                { 1, 5, 7, 9, 11 },
                { 2, 3, 4, 5, 10 },
                { 9, 10, 12, 14, 16}
            }

            1 2 3 4 5 5 7 9 9 10 10 11 12 14 16  <-- Single Array
            0 1 2 3 4 5 6 7 8 9  10 11 12 13 15  <-- Indexes
                          _

            Median is 9 at index 7

    matrix = {
                {1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}
        }

        1 2 3 4 5 8 9 11 12 13 21 23 25 27 29
        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

        Median is 11 at index 7
 */

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}
        };
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(median(matrix, m, n));
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    public static int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

}
