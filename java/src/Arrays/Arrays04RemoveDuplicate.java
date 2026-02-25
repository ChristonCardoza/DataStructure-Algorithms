package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arrays04RemoveDuplicate {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 2, 2, 3, 3 , 4, 5, 5};

        System.out.println(String.format("The array %s after removing duplicates using bruteforce is: %s", Arrays.toString(arr), Arrays.toString(bruteforce(Arrays.copyOf(arr, arr.length)))));

        System.out.println(String.format("The array %s after removing duplicates using optimal is: %s", Arrays.toString(arr), Arrays.toString(optimal(Arrays.copyOf(arr, arr.length)))));

    }

    private static int[] bruteforce(int[] arr) {
        // 1. create set from arr

        Set<Integer> set = new HashSet<>(Arrays.stream(arr).boxed().toList());

        int i =0;
        for(Integer n: set) {
            arr[i++] = n;
        }

        while(i<arr.length) {
            arr[i++] = 0;
        }

        return arr;
    }

    private static int[] optimal (int[] arr) {
        // 2 pointer

        int i = 0;

        for(int j=1; j<arr.length; j++) {

            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        i++;
        while(i < arr.length) {
            arr[i++] = 0;
        }

        return arr;
    }
}
