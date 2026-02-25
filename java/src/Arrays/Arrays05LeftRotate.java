package Arrays;

import java.util.Arrays;

public class Arrays05LeftRotate {

    public static void main(String[] args) {

        int [] arr = { 1, 2, 3, 4, 5};

        System.out.println(String.format("The array %S left rotate by 1 position is: %s", Arrays.toString(arr), Arrays.toString(leftRotateByOne(arr))));
    }

    private static int[] leftRotateByOne(int[] arr) {

        int temp = arr[0];

        for(int i=1; i<arr.length; i++) {

            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;

        return arr;
    }
}
