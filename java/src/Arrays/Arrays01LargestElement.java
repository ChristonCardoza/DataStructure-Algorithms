package Arrays;

import java.util.Arrays;

public class Arrays01LargestElement {

    public static void main(String[] args) {

        int[] arr = {3,2,1,5,2};

        System.out.printf("The largest Element from %s is %d%n", Arrays.toString(arr), findLargest(arr));
    }

    private static int findLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;

        for(int n : arr) {
            largest = Math.max(largest, n);
        }

        return largest;
    }
}
