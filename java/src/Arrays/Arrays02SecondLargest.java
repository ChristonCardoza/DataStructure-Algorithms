package Arrays;

import java.util.Arrays;

public class Arrays02SecondLargest {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5};

        System.out.println(String.format("The second largest from bruteforce O(nlogn+n) for %s is %d",  Arrays.toString(arr), bruteforce(arr)));

        System.out.println(String.format("The second largest from okiesh O(2n) for %s is %d",  Arrays.toString(arr), okiesh(arr)));

        System.out.println(String.format("The second largest from optimal O(2n) for %s is %d",  Arrays.toString(arr), optimal(arr)));
    }

    private static int bruteforce(int[] arr) {
        int size = arr.length;

        int[] sorted = Arrays.stream(arr).sorted().toArray();
        int largest = sorted[size-1];


        int i = size - 2;
        while (i >= 0) {
            if (sorted[i] < largest) { // strictly less ensures distinctness
                return sorted[i];
            }
            i--;
        }

        return largest;
    }

    private static int okiesh(int[] arr) {
        // 1. Find the largest first  -> n
        // 2. Iterate over the array and find 2nd largest -> n

        int largest = Integer.MIN_VALUE;

        for(int n : arr) {
            largest = Math.max(largest, n);
        }

        int slargest = Integer.MIN_VALUE;;

        for(int sl: arr) {
            if(sl > slargest && sl != largest){
                slargest = sl;
            }
        }

        return slargest;
    }

    private static int optimal(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;

        for(int n: arr) {

            if( n > largest ){
                slargest = largest;
                largest = n;
            }
            else if( n < largest && n > slargest){
                slargest = n;
            }
        }

        return slargest;
    }
}
