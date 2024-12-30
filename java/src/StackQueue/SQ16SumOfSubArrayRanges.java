package StackQueue;

public class SQ16SumOfSubArrayRanges {

    /*
        largest - smallest

        arr = [ 1, 4, 3, 2 }

        1 => 1-1 = 0                4 => 4-4 = 0                     3 => 3-3 = 0                  2 => 2-2 = 0
        1,4 => 4-1 = 3              4,3 => 4-3 = 1                   3,2 => 3-2 = 1
        1,4,3 => 4-1 = 3            4,3,2 => 4-2 = 2
        1,4,3,2 => 4-1 = 3

                        9       +                 3                +            1            +            0

               => 13
    */

    public static void main(String[] args) {

        int[] arr = { 1, 4, 3, 2};

        System.out.println("Bruteforce: "+ bruteforce(arr));

        System.out.println("Optimal Solution: Sum(subArrayMax) - Sum(subArrayMin)");
    }

    public static int bruteforce(int[] arr) {

        int sum = 0;

        for (int i=0; i<arr.length; i++) {

            int largest = arr[i];
            int smallest = arr[i];

            for(int j=i; j<arr.length; j++) {

                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }
}
