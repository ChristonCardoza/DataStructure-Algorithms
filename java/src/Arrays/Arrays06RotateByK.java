package Arrays;

import java.util.Arrays;

public class Arrays06RotateByK {

    public static void main(String[] args) {

        int [] arr = { 1, 2, 3, 4, 5, 6, 7};

        int d = 2;

        System.out.println(String.format("The array %S left rotate by %d position is: %s", Arrays.toString(arr), d, Arrays.toString(bruteforce(arr, d))));

        System.out.println(String.format("The array %S left rotate by %d position is: %s", Arrays.toString(arr), d, Arrays.toString(optimized(arr, d))));

    }

    private static int[] bruteforce(int[] arr, int k) {

        int len = arr.length;
        k = k % len;

        int[] temp = new int[k];
        int[] ans = Arrays.copyOf(arr, len); // [1, 2, 3, 4, 5, 6, 7]

        // copy the elements which needs to be shifted
        for(int i=0; i<k; i++){
            temp[i] = ans[i]; // [1, 2]
        }

        // shift remaining element
       for(int cnt=k; cnt<len; cnt++) {
           ans[cnt-k] = ans[cnt]; //  [3, 4, 5, 6, 7, 6, 7]
       }

       // put temp arr at the end of main array
       for(int i = len-k; i<len; i++) {
           ans[i] = temp[i - (len-k)]; // [3, 4, 5, 6, 7, 1, 2]
       }

       return ans;
    }

    private static int[] optimized(int[] arr, int k) {

        int len = arr.length;
        k = k % len;

        reverse(arr, 0, k-1);
        reverse(arr, k, len-1);
        reverse (arr, 0, len-1);

        return arr;
    }

    private static void reverse(int[] arr, int start, int end){

        while(end > start) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start ++;
            end --;
        }

    }
}
