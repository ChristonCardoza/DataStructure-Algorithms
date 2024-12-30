package StackQueue;

public class SQ19MaximalRectangle {
    /*
          10101
          10111  ----| 111   => 3 * 2
          11111  ----| 111       6
          10010

          prefix sum column wise and if we get 0 then don't add, just use 0

          10101              1  0  1  0  1
          10111      =>      2  0  2  1  2
          11111              3  1  3  2  3
          10010              4  0  0  3  0

          For each row in the prefix sum matrix, treat it as a histogram and calculate the largest rectangle area
          using the Largest Rectangle in Histogram logic
     */

    public static void main(String[] args) {

        int[][] mat = {
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println("Max Area: " + getMaxAreaRectangle(mat));
    }

    private static int getMaxAreaRectangle(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int maxArea = 0;
        int psum [][] = new int[n][m];


        // prepare prefix sum column wise
        for(int j=0; j < m; j++) {

            int sum = 0;

            for( int i=0; i<n; i++) {

                sum += mat[i][j];

                if( mat[i][j] == 0) sum = 0;

                psum[i][j] = sum;
            }
        }

        // find max area

        for(int i=0; i<n; i++) {

            maxArea = Math.max(maxArea, SQ18LargestRectangleHistogram.largestRectangle(psum[i]));
        }

        return maxArea;

    }
}
