package Arrays;

import java.util.Arrays;

public class Arrays08linearSearch {

    public static void main(String[] args) {
        int [] arr = { 1, 2, 3, 4, 5, 6, 7};

        System.out.println(String.format("Searching Element %d in  array %s present at index %d ", 4, Arrays.toString(arr),linearSearch(arr, 5)));
        System.out.println(String.format("Searching Element %d in  array %s present at index %d ", 10, Arrays.toString(arr),linearSearch(arr, 10)));

    }

    private static int linearSearch(int[] arr, int search) {

        int ans = -1;
        int len = arr.length;

        for(int i=0; i<len; i++) {
            if(arr[i] == search) {
                return i;
            }
        }

        return ans;
    }
}
