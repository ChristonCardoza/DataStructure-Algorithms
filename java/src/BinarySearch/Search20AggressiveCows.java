package BinarySearch;

import java.util.Arrays;

public class Search20AggressiveCows {

/*
    You are given an array 'arr' of size 'n' which denotes the position of stalls.
    You are also given an integer 'k' which denotes the number of aggressive cows.
    You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
    Find the maximum possible minimum distance.

                arr[] = {0, 3, 4, 7, 10, 9} cows = 4
    sort ->             {0, 3, 4, 7, 9, 10}   => to get consecutive distance

                        c1 c2 c3 c4           => min distance can be found between c2 and c3 ie 1
                        c1    c2     c3  c4   => min distance can be found between c3 and c4 ie 1
                        c1    c2  c3     c4   => min distance can be found between all of them ie 3

        Here min distance Max value is 3

        There must be at least 2 cows, so that max distance is between start and end of stall

        first = 1  last = arr[max]-arr[min]
 */

    public static void main(String[] args) {

        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;

        Arrays.sort(stalls);

        System.out.println("Bruteforce Approach:");
        System.out.println(bruteforce(stalls, cows));

        System.out.println("Binary Approach:");
        System.out.println(binarySearch(stalls, cows));
    }

    public static boolean canWePlaceCow(int[] stalls, int distance, int cows){

        int placedCow = 1, lastPlaced = stalls[0];

        for(int i=1; i<stalls.length; i++){

            if(stalls[i] - lastPlaced >= distance){
                placedCow ++;
                lastPlaced = stalls[i];
            }
        }

        if(placedCow >= cows){
            return true;
        }

        return false;
    }

    public static int bruteforce(int[] stalls, int cows){

        int min = stalls[0];
        int max = stalls[stalls.length-1];

        for(int i=min; i<=max-min; i++){

            if(canWePlaceCow(stalls, i, cows)){
                continue;
            } else {
                return  i- 1;
            }
        }

        return max-min;
    }

    public static int binarySearch(int[] stalls, int cow){

        int low = 1, high = stalls[stalls.length-1] - stalls[0], ans = -1;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(canWePlaceCow(stalls, mid, cow)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        return ans;
    }


}
