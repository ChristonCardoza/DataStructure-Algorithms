package Arrays;

import java.util.Arrays;

public class Arrays03IsArraySorted {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5};
        int[] arr2 = { 1, 12, 3, 5, 4};

        System.out.println(String.format("The array %s is sorted: %b", Arrays.toString(arr1), isSorted(arr1)));
        System.out.println(String.format("The array %s is sorted: %b", Arrays.toString(arr2), isSorted(arr2)));
    }

    private static boolean isSorted(int[] arr) {
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                return false;
            }
        }

        return true;
    }
}
