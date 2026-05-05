package Arrays;

import java.util.Arrays;

public class Arrays07MoveAllZeroEnd {

    public static void main(String[] args) {
        int [] arr = { 1, 0, 2, 3, 2, 0 , 0, 4, 5, 1};

        System.out.println(String.format("The array %s after moving all 0 at end %s ", Arrays.toString(arr), Arrays.toString(bruteforce(arr))));
        System.out.println(String.format("The array %s after moving all 0 at end %s ", Arrays.toString(arr), Arrays.toString(optimal(arr))));

    }

    private static int[] bruteforce(int[] arr) {

        // Storing all non-zero items in new array
        int len = arr.length;
        int[] newArr = new int[len];

        int i = 0;

        for(int value: arr) {

            if(value != 0) {
                newArr[i] = value;
                i++;
            }
        }

        return newArr;
    }

    private static int[] optimal (int[] arr) {

        int i =0;
        int j = i;
        int len = arr.length;
        int counter = 0;

        while(counter < len) {

            if(arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }

            i ++;
            counter ++;
        }

        while(j < len) {
            arr[j] = 0;
            j++;
        }

        return arr;
    }
}
